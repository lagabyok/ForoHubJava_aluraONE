package com.example.foro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories; // Import
@SpringBootApplication(scanBasePackages = "com.example.foro")
@EnableJpaRepositories(basePackages = "com.example.foro.repository")  // Ruta correcta del repositorio
@EntityScan(basePackages = "com.example.foro.model")
public class ForoHubApplication {

	public static void main(String[] args) {
		SpringApplication.run(ForoHubApplication.class, args);
	}
}
