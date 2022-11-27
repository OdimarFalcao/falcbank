package com.falcbank.falcbank.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class NotificationService {

    private final JavaMailSender javaMailSender;

    public NotificationService(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    public void sender(String to,String title, String content){
        log.info("Notificação enviada");

        var message = new SimpleMailMessage();

        message.setTo(to);
        message.setSubject(title);
        message.setText(content);

        javaMailSender.send(message);
    }
}
