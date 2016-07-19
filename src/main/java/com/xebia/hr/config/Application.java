package com.xebia.hr.config;


import java.nio.charset.Charset;
import java.util.Arrays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.SecurityAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.MediaType;
import org.springframework.http.converter.StringHttpMessageConverter;

/**
 * Created by anirudh on 13/07/15.
 */

@SpringBootApplication//(exclude={SecurityAutoConfiguration.class})
@ComponentScan(basePackages = {"com.xebia.hr"} )
@EntityScan(basePackages = {"com.xebia.hr.entity"})
@EnableJpaRepositories(basePackages = {"com.xebia.hr.repository"})
@Import({SecurityConfig.class})
public class Application extends SpringBootServletInitializer {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Application.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(Application.class);
    }

    @Bean
    public StringHttpMessageConverter mappingStringHttpMessageConverter() {
        StringHttpMessageConverter stringConverter = new StringHttpMessageConverter(Charset.forName("UTF-8"));
        stringConverter.setSupportedMediaTypes(Arrays.asList(MediaType.TEXT_PLAIN, MediaType.TEXT_HTML, MediaType.APPLICATION_JSON));
        return stringConverter;
    }
}
