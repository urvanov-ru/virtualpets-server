package ru.urvanov.virtualpets.server.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.SimpleMailMessage;

@Configuration
public class MailConfig {
    
    @Bean
    public SimpleMailMessage templateMessage(
            @Value("${mail.from}") String mailFrom,
            @Value("${mail.subject}") String mailSubject) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom(null);
        simpleMailMessage.setSubject(mailSubject);
        return simpleMailMessage;
    }

}
