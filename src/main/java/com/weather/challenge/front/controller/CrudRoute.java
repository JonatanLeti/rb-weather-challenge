package com.weather.challenge.front.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.inject.Inject;
import lombok.extern.slf4j.Slf4j;

import javax.inject.Singleton;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Slf4j
@Singleton
@Path("/services")
public class CrudRoute{

    private final Gson GSON = new GsonBuilder().create();

    @Inject
    public CrudRoute() {
    }

    @POST
    @Path("/create-dashboard")
    @Produces(MediaType.APPLICATION_JSON)
    public String findPeriod(List<String> cityList) throws Exception {
        log.info("{}", cityList);


        return "FIND PERIOD";
    }

    @GET
    @Path("/all-period")
    @Produces(MediaType.APPLICATION_JSON)
    public String findAllPeriod() throws Exception {
        return "FIND ALL PERIOD";
    }

}