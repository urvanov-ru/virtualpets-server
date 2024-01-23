package ru.urvanov.virtualpets.server.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.SimpleMailMessage;

@Configuration
public class MailConfig {
    
    @Value("${mail.from}")
    private String mailFrom;
    
    @Value("${mail.subject}")
    private String mailSubject;
    
    @Bean
    public SimpleMailMessage templateMessage() {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom(null);
        simpleMailMessage.setSubject(mailSubject);
        return simpleMailMessage;
    }

}
