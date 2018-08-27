package com.weather.challenge.main;

import com.google.inject.servlet.GuiceFilter;
import com.sun.jersey.spi.container.servlet.ServletContainer;
import com.weather.challenge.main.module.WeatherServletContextListener;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.DefaultServlet;
import org.eclipse.jetty.servlet.ServletHolder;
import org.eclipse.jetty.webapp.WebAppContext;

import javax.servlet.DispatcherType;
import java.util.EnumSet;

@Slf4j
public class StartApp {

    private static final int DEFAULT_PORT = 8080;
    private static final String CONTEXT_PATH = "/";
    private static final String WEB_APP_DIR = "src/main/webapp/";

    public StartApp() {
    }

    public static void main(String[] args) throws Exception {

        Server server = new Server(DEFAULT_PORT);

        WebAppContext webAppContext = new WebAppContext();

        webAppContext.setContextPath(CONTEXT_PATH);
        webAppContext.setResourceBase(WEB_APP_DIR);

        webAppContext.setParentLoaderPriority(true);
        webAppContext.addEventListener(new WeatherServletContextListener());

        webAppContext.addFilter(GuiceFilter.class, "/*", EnumSet.allOf(DispatcherType.class));

        server.setHandler(webAppContext);
        server.start();
        server.join();
    }

}