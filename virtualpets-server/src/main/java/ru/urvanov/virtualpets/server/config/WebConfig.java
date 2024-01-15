package ru.urvanov.virtualpets.server.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("site/download").setViewName("download");
        registry.addViewController("site/information").setViewName("information/list");
        registry.addViewController("site/information/gameHelp").setViewName("information/gameHelp");
    }
}
