package com.xebia.hr.config;

import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@Configuration
public class MailConfig {

	private final static Logger log = LoggerFactory.getLogger(MailConfig.class);
	
	@Autowired
    private Environment environment;
	
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
		log.info("Setting Mail properties...");
		log.info("Host: "+sender.getHost());
		log.info("Post: "+sender.getPort());
		log.info("User: "+sender.getUsername());
    	return sender;
    }
	
}
