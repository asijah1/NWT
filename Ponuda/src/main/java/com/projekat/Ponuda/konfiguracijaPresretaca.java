package com.projekat.Ponuda;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class konfiguracijaPresretaca implements WebMvcConfigurer {
	
    @Autowired
    Presretac presretac;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(presretac);
    }
}