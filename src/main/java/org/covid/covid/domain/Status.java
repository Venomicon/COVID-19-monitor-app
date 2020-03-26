package org.covid.covid.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Status {
    @JsonProperty("confirmed")
    private Long confirmed;

    @JsonProperty("deaths")
    private Long deaths;

    @JsonProperty("recovered")
    private Long recovered;

    @Override
    public String toString() {
        return "Status{" +
                "confirmed=" + confirmed +
                ", deaths=" + deaths +
                ", recovered=" + recovered +
                '}';
    }
}
