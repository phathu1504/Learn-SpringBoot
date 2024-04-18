package learn.springboot.ContructorInjection.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication (
		scanBasePackages = {
				"learn.springboot.ContructorInjection.application",
				"learn.springboot.ContructorInjection.rest",
				"learn.springboot.ContructorInjection.service",
		}
)
public class ContructorInjectionApplication {

	public static void main(String[] args) {
		SpringApplication.run(ContructorInjectionApplication.class, args);
	}

}
