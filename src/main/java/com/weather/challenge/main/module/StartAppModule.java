package com.weather.challenge.main.module;

import com.google.inject.*;
import com.google.inject.name.Names;
import com.weather.challenge.main.StartApp;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.Properties;

@Slf4j
public class StartAppModule extends AbstractModule {

    @Override
    protected void configure() {
        loadEnvironmentalProperties();
    }

    private void loadEnvironmentalProperties() {
        try {
            log.info("Loading default properties");
            Properties properties = new Properties();
            properties.load(StartApp.class.getResourceAsStream("/application.properties"));
            Names.bindProperties(binder(), properties);

        } catch (IOException e) {
            throw new RuntimeException("Can not read property file(s)", e);
        }

    }
}
