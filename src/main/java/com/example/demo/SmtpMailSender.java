package com.example.demo;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class SmtpMailSender {

    @Autowired
    private JavaMailSender javaMailSender;

    public static String[] input (String filename) {
        List<String> text = new ArrayList<>();
        String str = null;
        BufferedReader br;

        {
            try {
                br = new BufferedReader(new FileReader(filename));
                while ((str = br.readLine()) != null) {
                    text.addAll(Arrays.asList(str.split("\n")));
                }
            } catch (IOException e) {
                //e.printStackTrace();
            }
        }
        return text.toArray(new String[text.size()]);
    }

    public void send(String subject, String body, String ... to) throws MessagingException {

        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper;

        helper = new MimeMessageHelper(message, true); // true indicates
        // multipart message
        helper.setSubject(subject);
        helper.setTo(to);
        helper.setText(body, true); // true indicates html
        // continue using helper object for more functionalities like adding attachments, etc.

        javaMailSender.send(message);


    }

}
