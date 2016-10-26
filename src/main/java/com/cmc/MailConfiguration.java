package com.cmc;

import java.util.Date;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@Configuration
@PropertySource("classpath:email.properties")
public class MailConfiguration {

    @Value("${email.protocol}")
    private String protocol;
    @Value("${email.host}")
    private String host;
    @Value("${email.port}")
    private int port;
    @Value("${email.smtp.auth}")
    private boolean auth;
    @Value("${email.smtp.starttls.enable}")
    private boolean starttls;
    @Value("${email.from}")
    private String from;
    @Value("${email.username}")
    private String username;
    @Value("${email.password}")
    private String password;

    @Bean
    public JavaMailSender javaMailSender() {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        Properties mailProperties = new Properties();
        mailProperties.put("mail.smtp.auth", auth);
        mailProperties.put("mail.smtp.starttls.enable", starttls);
        mailProperties.put("mail.smtp.ssl.trust", "smtp.gmail.com");
        mailSender.setJavaMailProperties(mailProperties);
        mailSender.setHost(host);
        mailSender.setPort(port);
        mailSender.setProtocol(protocol);
        mailSender.setUsername(username);
        mailSender.setPassword(password);
        return mailSender;
    }
    @Bean
    public SimpleMailMessage simpleTemplate(){
    	SimpleMailMessage template = new SimpleMailMessage();
    	template.setFrom(from);
    	template.setSubject("QMS " + new Date().toLocaleString());
    	
    	return template;
    }
}