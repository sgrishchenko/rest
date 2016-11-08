package com.example.docs;

import com.example.model.ModelApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DocsApplication {

	public static void main(String[] args) {
		SpringApplication.run(new Object[]{ModelApplication.class, DocsApplication.class}, args);
	}
}
