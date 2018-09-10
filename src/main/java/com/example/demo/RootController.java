package com.example.demo;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.example.demo.SmtpMailSender.input;

@RestController
public class RootController {

    @Autowired
    private SmtpMailSender smtpMailSender;
    @Autowired
    UserEmailRepository userEmailRepository;

    List<String> to = new ArrayList<>();
    String[] toSend;
    List<String> toPib = new ArrayList<>();
    String[] toPibs;

    @RequestMapping("/send-mail")
    public void sendMail() throws MessagingException {

        for(UserEmail product : userEmailRepository.findAll()) {
          to.add(product.getEmail());
        }

        for(UserEmail product : userEmailRepository.findAll()) {
            toPib.add(product.getPib());
        }

        toSend = to.toArray(new String[to.size()]);
        toPibs = toPib.toArray(new String[toPib.size()]);

        for (int i = 0; i < toSend.length; i++) {
            smtpMailSender.send("training", "<h3>Dear " + toPibs[i] +"<h3>" +
                "We have to inform you that you do not participate in all required adaptational tests.\n " +
                "Please, complete the adaptation.\n\n" +
                "We wish you success in your professional achievements. \n" +
                "<p>If you have any questions, please contact us.\n\n</p>" +
                "<p>Best regards, \n</p>" +
                "<p>EPAM Team</p>", toSend[i]);
        }

        /*smtpMailSender.send( "Training EPAM", Arrays.toString(toPibs)+"<h1>Dear student!</h1>"+"\n" +
                "We have to inform you that you do not participate in all required adaptational tests.\n " +
                "Please, complete the adaptation.\n\n" +
                "We wish you success in your professional achievements. \n" +
                "<p>If you have any questions, please contact us.\n\n</p>" +
                "<p>Best regards, \n</p>" +
                "<p>EPAM Team</p>", toSend);
*/
        smtpMailSender.send("EPAM", "<h3>List of students that did not pass the "
            + "checking requirements<h3> " + "<p>" +
            Arrays.toString(toSend) + "</p>", "klymenko.nastasia@gmail.com");

    }




}
