package com.vfs.birthdayproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class BirthdayProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(BirthdayProjectApplication.class, args);
	}

}
