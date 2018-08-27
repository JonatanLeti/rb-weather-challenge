package com.weather.challenge.main.module;

@FunctionalInterface
public interface Route {
    default void routeWebSockets() {
        // is no websocket, do nothing
    }

    void routeServices();

}