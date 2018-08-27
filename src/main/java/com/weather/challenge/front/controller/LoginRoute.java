package com.weather.challenge.front.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.inject.Inject;
import com.weather.challenge.domain.UserWeatherPreferenceDTO;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import javax.inject.Singleton;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Slf4j
@Singleton
@Path("/log")
public class LoginRoute {

    private final Gson GSON = new GsonBuilder().create();

    @Inject
    public LoginRoute() {
    }

    @GET
    @Path("/in")
    @Produces(MediaType.APPLICATION_JSON)
    public String getWeatherInDay(@QueryParam("user") String user, @QueryParam("pass") String pass) throws Exception {

        if(StringUtils.isNoneBlank(user) && StringUtils.isNoneBlank(pass)){
            return GSON.toJson(UserWeatherPreferenceDTO.builder().user(user).build());
        }

        throw new IllegalArgumentException("User is not defined");
    }

}