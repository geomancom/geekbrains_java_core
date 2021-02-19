package Dz6;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.Serializable;


class WeatherResponse implements Serializable {

    public static void main(String[] args) throws JsonProcessingException{
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES , false);
        WeatherResponse weatherResponse = new WeatherResponse();



    }

    private String Date;
    private String weatherText;
    private String temperature;

    @JsonGetter("Date")
    public String getDate(){ return Date;}

    @JsonSetter("Date")
    public void setDate(String Date){ this.Date = Date;}

    @JsonGetter("weatherText")
    public String getWeatherText(){ return weatherText;}

    @JsonSetter("weatherText")
    public void setWeatherText(String IconPhrase){ this.weatherText = IconPhrase;}

    @JsonGetter("temperature")
    public String getTemperature(){ return temperature;}

    @JsonSetter("temperature")
    public void setTemperature(String Value){ this.temperature = Value;}

    public WeatherResponse(String Date, String weatherText, String temperature){
        this.Date = Date;
        this.weatherText = weatherText;
        this.temperature = temperature;

    }

    public WeatherResponse(){

    }

    @Override
    public String toString() {
        return "на дату " + Date +
                ", ожидается " + weatherText +
                ", температура " + temperature +
                '}';
    }

}
