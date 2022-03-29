package com.ssafy.tnt.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;

@Configuration
public class MailConfig {
    @Bean
    public JavaMailSender getJavaMailSender(){
        JavaMailSenderImpl mailSender=new JavaMailSenderImpl();

        mailSender.setHost("smtp.gmail.com");
        mailSender.setPort(587);
        mailSender.setUsername("ssafytest206@gmail.com");
        mailSender.setPassword("testssafy1234");

        Properties properties=mailSender.getJavaMailProperties();
        properties.put("mail.smtp.auth","true");
        properties.put("mail.transport.protocol","smtp");
        properties.put("mail.smtp.starttls.enable","true");
        properties.put("mail.debug","true");
        return mailSender;
    }
}
