package Dz_8;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)

public class Maximum {

    @JsonProperty("Value")
    public Double value;
    @JsonProperty("Unit")
    public String unit;
    @JsonProperty("UnitType")
    public Integer unitType;
    @Override
    public  String toString(){
        return  "Максимальная температура: " + value + " " + unit;
    }
}