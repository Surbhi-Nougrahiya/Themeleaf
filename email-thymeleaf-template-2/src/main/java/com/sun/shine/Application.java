package com.sun.shine;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application implements ApplicationRunner{


    @Autowired
    private EmailService emailService;

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(ApplicationArguments applicationArguments) throws Exception {

        Mail mail = new Mail();
        mail.setFrom("someone@gmail.com");
        mail.setTo("som@gmail.com");
       
        mail.setSubject("Sending Email with Thymeleaf HTML Template Example");

        Map<String, String> model = new HashMap<String, String>();
        model.put("name", "Somebody");
        model.put("location", "Bangalore");
        model.put("signature", "https://ItWillBEDone.com");
        mail.setContent(model);

        emailService.sendSimpleMessage(mail);
    }
}
