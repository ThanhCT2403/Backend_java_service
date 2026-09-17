package vn.demo.backend_java_service;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BackendJavaServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendJavaServiceApplication.class, args);
	}
}
