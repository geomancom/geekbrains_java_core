package Dz6;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;

import java.io.IOException;
import java.util.List;

public class GetLocationsKey {

    private static final String BASE_HOST = "dataservice.accuweather.com";
    private static final String FORECAST = "forecasts";
    private static final String LOCATIONS = "locations";
    private static final String API_VERSION = "v1";
    private static final String FORECAST_TYPE = "daily";
    private static final String LOCATIONS_TYPE = "cities";
    private static final String LOCATIONS_TYPE_COUNTRY_CODE = "RU";
    private static final String SEARCH = "search";
    private static final String FORECAST_PERIOD = "5day";


    private static final String SAINT_PETERSBURG_KEY = "295212";
    private static final String API_KEY = "v9wHx1BbT7i288uxKuAkAuh5srpCfomM";

    public GetLocationsKey(String city) throws IOException {
        System.out.println("Обрабатываем запрос город: "+city);

        OkHttpClient client = new OkHttpClient();





        HttpUrl url_id = new HttpUrl.Builder()
                .scheme("http")
                .host(BASE_HOST)
                .addPathSegment(LOCATIONS)
                .addPathSegment(API_VERSION)
                .addPathSegment(LOCATIONS_TYPE)
                .addPathSegment(LOCATIONS_TYPE_COUNTRY_CODE)
                .addPathSegment(SEARCH)
                .addQueryParameter("apikey", API_KEY)
                .addQueryParameter("q", city)
                .build();

        System.out.println(url_id.toString());


        Request requesthttp = new Request.Builder()
                .addHeader("accept", "application/json")
                .url(url_id)
                .build();

        String jsonResponse = client.newCall(requesthttp).execute().body().string();
        System.out.println(jsonResponse);


        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES , false);

        String key = objectMapper.readTree(jsonResponse).get(0).at("/Key").asText();
        System.out.println(key);

        List<Cities> cities = objectMapper.readValue(jsonResponse, new TypeReference<List<Cities>>() {});
        System.out.println(cities.toString());



        HttpUrl url = new HttpUrl.Builder()
                .scheme("http")
                .host(BASE_HOST)
                .addPathSegment(FORECAST)
                .addPathSegment(API_VERSION)
                .addPathSegment(FORECAST_TYPE)
                .addPathSegment(FORECAST_PERIOD)
                .addPathSegment(key)
                .addQueryParameter("apikey", API_KEY)
                .addQueryParameter("language", "ru-ru")
                .addQueryParameter("metric", "true")
                .build();

        System.out.println(url.toString());
        Request requesthttp2 = new Request.Builder()
                .addHeader("accept", "application/json")
                .url(url)
                .build();

        String jsonResponse2 = client.newCall(requesthttp2).execute().body().string();
        System.out.println(jsonResponse2);
        jsonResponse2 = "["+jsonResponse2+"]";
        System.out.println(jsonResponse2);

        ObjectMapper objectMapper2 = new ObjectMapper();
        objectMapper2.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES , false);
        List<WeatherResponse> weatherResponses = objectMapper2.readValue(jsonResponse2, new TypeReference<List<WeatherResponse>>() {});
        System.out.println("В городе "+city+" "+weatherResponses.toString());


    }
}

