package com.act4new.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.annotation.EnableAsync;


@SpringBootApplication
@EnableAsync
public class Act4newBackendApplication {

	public static void main(String[] args) {

		ApplicationContext ctx = SpringApplication.run(Act4newBackendApplication.class, args);
	}

}
