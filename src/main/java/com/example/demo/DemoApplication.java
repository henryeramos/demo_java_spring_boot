package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

import com.example.demo.repository.BlogRepository;
import com.example.demo.modelo.Blog;
@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	@Bean
	public CommandLineRunner setup(BlogRepository blogRepository) {
		return (args)->{
			blogRepository.save(new Blog("Titulo 1 Java","Contenido java"));
			blogRepository.save(new Blog("Titulo 2 Spring","Contenido Spring"));
			blogRepository.save(new Blog("Titulo 3 Spring boot","Contenido Spring boot"));
			blogRepository.save(new Blog("Titulo 4 Eclipse","Contenido eclipse"));
		};
		
	}
}
