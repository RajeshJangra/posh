package com.xebia.hr.config;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@EnableWebMvc
public class WebConfig extends WebMvcConfigurerAdapter {

	@Autowired
    private Environment environment;
	
	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**");
	}
	
	@Bean
    public JavaMailSender javaMailSenderImpl(){
    	Properties javaMailProperties = new Properties();

    	javaMailProperties.setProperty("mail.transport.protocol", environment.getProperty("mail.transport.protocol"));
    	javaMailProperties.setProperty("mail.smtp.auth", environment.getProperty("mail.smtp.auth"));
    	javaMailProperties.setProperty("mail.smtp.starttls.enable", environment.getProperty("mail.smtp.starttls.enable"));
    	javaMailProperties.setProperty("mail.debug", environment.getProperty("mail.debug"));

        JavaMailSenderImpl sender = new JavaMailSenderImpl();
        sender.setHost(environment.getRequiredProperty("mail.smtp.host"));
        sender.setPort(Integer.parseInt(environment.getRequiredProperty("mail.smtp.port")) );
        sender.setUsername(environment.getRequiredProperty("mail.user"));
        sender.setPassword(environment.getRequiredProperty("mail.password"));
		sender.setJavaMailProperties(javaMailProperties );

    	return sender;
    }
}