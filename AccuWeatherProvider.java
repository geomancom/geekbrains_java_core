package Dz_8;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.*;
import java.util.List;

public class AccuWeatherProvider implements WeatherProvider {
    private static final String API_KEY = ApplicationGlobalState.getInstance().getApiKey();
    private static final String HOST = "dataservice.accuweather.com";
    private static final String FORECAST = "forecasts";
    private static final String V = "v1";
    private static final String HOURLY = "hourly";
    private static final String HOURS = "12hour";
    private static final String DAILY = "daily";
    private static final String DAYS = "5day";


    private final OkHttpClient client = new OkHttpClient();
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void getWeather(Periods periods) throws IOException {
        String cityKey = detectCityKey();
        if (periods.equals(Periods.NOW)) {
            HttpUrl url = new HttpUrl.Builder()
                    .scheme("http").host(HOST)
                    .addPathSegment(FORECAST)
                    .addPathSegment(V)
                    .addPathSegment(HOURLY)
                    .addPathSegments(HOURS)
                    .addPathSegment(cityKey)
                    .addQueryParameter("apikey", API_KEY)
                    .addQueryParameter("language", "ru-ru")
                    .addQueryParameter("metric", "true")
                    .build();

            Request request = new Request.Builder()
                    .addHeader("accept", "Application/Json")
                    .url(url)
                    .build();
            Response response = client.newCall(request).execute();
            String res = response.body().string();
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            List<WeatherResponse> weatherResponse = objectMapper.readValue(res, new TypeReference<List<WeatherResponse>>() {
            });
            System.out.println(weatherResponse);


        } else {
            if (periods.equals(Periods.FIVE_DAYS)) {
                HttpUrl url = new HttpUrl.Builder()
                        .scheme("http").host(HOST)
                        .addPathSegment(FORECAST)
                        .addPathSegment(V)
                        .addPathSegment(DAILY)
                        .addPathSegments(DAYS)
                        .addPathSegment(cityKey)
                        .addQueryParameter("apikey", API_KEY)
                        .addQueryParameter("language", "ru-ru")
                        .addQueryParameter("metric", "true")
                        .build();

                Request request = new Request.Builder()
                        .addHeader("accept", "Application/Json")
                        .url(url)
                        .build();
                Response response = client.newCall(request).execute();
                String res = response.body().string();
                ObjectMapper objectMapper = new ObjectMapper();
                objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
                ForecastsResponce forecastsResponces = objectMapper.readValue(res, new TypeReference<ForecastsResponce>() {
                });
                System.out.println(forecastsResponces);
            }
        }
    }

    private String detectCityKey() throws IOException {
        String selectedCity = ApplicationGlobalState.getInstance().getSelectedCity();
        HttpUrl locationUrl = new HttpUrl.Builder()
                .scheme("http").host(HOST)
                .addPathSegment("locations")
                .addPathSegment(V)
                .addPathSegment("cities")
                .addPathSegment("autocomplete")
                .addQueryParameter("apikey", API_KEY)
                .addQueryParameter("q", selectedCity)
                .build();

        Request request = new Request.Builder()
                .addHeader("accept", "Application/Json")
                .url(locationUrl).build();
        Response response = client.newCall(request).execute();

        if (!response.isSuccessful()) {
            throw new IOException("Нет информации о запрашиваемом городе" + response.body().string()
                    + response.code());
        }
        String jsR = response.body().string();
        System.out.println("Ищу город " + selectedCity);

        if (objectMapper.readTree(jsR).size() > 0) {
            String cityName = objectMapper.readTree(jsR).get(0).at("/LocalizedName").asText();
            String countryName = objectMapper.readTree(jsR).get(0).at("/Country/LocalizedName").asText();
            System.out.println("Найдено " + cityName + "/" + countryName);
        } else throw new IOException("Город не найден");
        return objectMapper.readTree(jsR).get(0).at("/Key").asText();
    }
}