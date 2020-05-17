package com.act4new.backend.controller;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.act4new.backend.config.EmailConfig;
import com.act4new.backend.dao.ArticleDAO;
import com.act4new.backend.dao.UserDAO;
import com.act4new.backend.service.MailService;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/sendEmail")
public class EmailController {
	
	private EmailConfig emailConfig;
	private MailService mailService;
	private ArticleDAO articleDAO;
	private UserDAO userDAO;
	
	@Autowired
	public EmailController(EmailConfig emailConfig, MailService mailService, ArticleDAO articleDAO, UserDAO userDAO) {
		super();
		this.emailConfig = emailConfig;
		this.mailService = mailService;
		this.articleDAO = articleDAO;
		this.userDAO = userDAO;
	}
	
	@Async("forSendEmail")
	@PostMapping
	//receiver proprietaire de l article
	//email_user email de current user (celui qui a loué l artice)
	public String sendEmail(@RequestParam("receiver")String receiver,
						@RequestParam("nom")String nom,
						@RequestParam("email_user")String email_user) {
		
		//Create a mail sender
		JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
		mailSender.setHost(this.emailConfig.getHost());
		mailSender.setPort(this.emailConfig.getPort());
		mailSender.setUsername(this.emailConfig.getUsername());
		mailSender.setPassword(this.emailConfig.getPassword());

		Properties props = mailSender.getJavaMailProperties();
		props.put("mail.transport.protocol", "smtp");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.debug", "true");
		props.put("mail.smtp.ssl.trust", "smtp.gmail.com");
		
		//Create a mail instance
		MimeMessagePreparator messagePreparator = mimeMessage -> {
	        MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage);
	        messageHelper.setTo(receiver);
	        messageHelper.setSubject("Notification - Article loué");
	        String content = mailService.build(nom, email_user);
	        messageHelper.setText(content, true);
	    };
		
		// Send
	    mailSender.setDefaultEncoding("UTF-8");
		mailSender.send(messagePreparator);
		return "Mail envoyé";
	}

}
