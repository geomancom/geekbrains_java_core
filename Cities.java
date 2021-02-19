package Dz6;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;

public class Cities {
    private String Key;

    @JsonGetter("Key")
    public String getKey(){ return Key;}

    @JsonSetter("Key")
    public void setKey(String Key){ this.Key = Key;}

    public Cities(String Key){
        this.Key = Key;

    }

    public Cities(){

    }
    @Override
    public String toString() {
        return "Cities{" +
                "Key=" + Key +
                '}';
    }
}
