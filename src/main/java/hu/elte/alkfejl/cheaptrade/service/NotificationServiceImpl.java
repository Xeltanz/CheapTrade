package hu.elte.alkfejl.cheaptrade.service;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

public class NotificationServiceImpl implements NotificationService {

    private final JavaMailSender javaMailSender;

    public NotificationServiceImpl(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    @Override
    public void sendEmail(String address, String subject, String text) {
        new Thread(() -> {
            SimpleMailMessage msg = new SimpleMailMessage();
            msg.setTo(address);
            msg.setSubject(subject);
            msg.setText(text);
            javaMailSender.send(msg);
        }).start();
    }
}

