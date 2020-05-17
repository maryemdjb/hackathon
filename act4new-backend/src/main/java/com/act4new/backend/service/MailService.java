package com.act4new.backend.service;

import java.util.concurrent.Executor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;


@Service
@EnableAsync
public class MailService {

	private TemplateEngine templateEngine;
	
	@Autowired
	public MailService(TemplateEngine templateEngine) {
		super();
		this.templateEngine = templateEngine;
	}
	
	public String build(String nom, String email_user) {
        Context context = new Context();
        context.setVariable("nom", nom);
        context.setVariable("email_user", email_user);
//        context.setVariable("dateD", dateD);
//        context.setVariable("dateF", dateF);
        return templateEngine.process("mailTemplate", context);
    }

	@Bean(name = "forSendEmail")
    public Executor forSendEmail() {
        return new ThreadPoolTaskExecutor();
    }
	
	
}
