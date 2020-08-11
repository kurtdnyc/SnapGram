package dev.snapgram.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("dev.snapgram")
public class SnapGramSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(SnapGramSpringApplication.class, args);
	}

}
