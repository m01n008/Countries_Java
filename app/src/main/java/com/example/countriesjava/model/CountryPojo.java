package com.example.countriesjava.model;

import com.google.gson.annotations.SerializedName;

public class CountryPojo {

    @SerializedName("name")
    private String Name;
    @SerializedName("capital")
    private String Capital;
    @SerializedName("flagPNG")
    private String Flag;

  public  CountryPojo(String Name, String Capital, String Flag) {
        this.Name = Name;
        this.Capital = Capital;
        this.Flag = Flag;

    }


    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getCapital() {
        return Capital;
    }

    public void setCapital(String capital) {
        Capital = capital;
    }

    public String getFlag() {
        return Flag;
    }

    public void setFlag(String flag) {
        Flag = flag;
    }


}
