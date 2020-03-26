package org.covid.covid.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Country extends Status {
    @JsonProperty("country")
    private String countryName;

    public Country() {
    }

    public Country(Long confirmed, Long deaths, Long recovered, String countryName) {
        super(confirmed, deaths, recovered);
        this.countryName = countryName;
    }

    @Override
    public String toString() {
        return "Country{" +
                "countryName='" + countryName + '\'' +
                super.toString();
    }
}
