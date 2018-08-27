package com.weather.challenge.main.module;

import com.google.inject.servlet.ServletModule;
import com.weather.challenge.front.controller.CrudRoute;
import com.weather.challenge.front.controller.LoginRoute;
import com.sun.jersey.guice.spi.container.servlet.GuiceContainer;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.jetty.servlet.DefaultServlet;

@Slf4j
public class RouterModule extends ServletModule {

    @Override
    protected void configureServlets(){
        bindings();
        filters();
    }

    private void bindings() {
        bind(LoginRoute.class);
        bind(CrudRoute.class);
        bind(DefaultServlet.class).asEagerSingleton();
        bind(GuiceContainer.class).asEagerSingleton();
        serve("/*").with(DefaultServlet.class);
    }

    private void filters() {
        filter("/services/*", "/log/*").through(GuiceContainer.class);
    }
}
