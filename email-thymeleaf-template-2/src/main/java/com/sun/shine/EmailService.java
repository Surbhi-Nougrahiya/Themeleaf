package com.sun.shine;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Map;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring4.SpringTemplateEngine;

@Service
public class EmailService {
	 @Autowired
	    private JavaMailSender emailSender;

	    @Autowired
	    private SpringTemplateEngine templateEngine;


	    public void sendSimpleMessage(Mail mail) throws MessagingException, IOException {
	        MimeMessage message = emailSender.createMimeMessage();
	        MimeMessageHelper helper = new MimeMessageHelper(message,
	                StandardCharsets.UTF_8.name());
	        
//	        MimeMessageHelper helper = new MimeMessageHelper(message, "UTF-8").

//	        helper.addAttachment("logo.jpg", new ClassPathResource("beauty&beard.jpg"));

	        Context context = new Context();
	        for(Map.Entry<String,String> entry : mail.getContent().entrySet()) {
	        	context.setVariable(entry.getKey(), entry.getValue());
	        }
//	        context.setVariables(mail.getContent());
	        String html = templateEngine.process("email-template", context);

	        helper.setTo(mail.getTo());
	        helper.setText(html, true);
	        helper.setSubject(mail.getSubject());
	        helper.setFrom(mail.getFrom());
	        emailSender.send(message);
	    }

}
