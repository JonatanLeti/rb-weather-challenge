package com.weather.challenge.domain;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class UserWeatherPreferenceDTO {

    private String user;
    private List<String> locationInterestList;
}
