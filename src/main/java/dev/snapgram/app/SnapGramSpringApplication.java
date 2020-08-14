package dev.snapgram.app;

import org.springframework.boot.SpringApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan("dev.snapgram")
@EntityScan("dev.snapgram.entities")
@EnableJpaRepositories("dev.snapgram.repositories")
public class SnapGramSpringApplication {
	
    private static final Logger LOGGER = LoggerFactory.getLogger(SnapGramSpringApplication.class);


	public static void main(String[] args) {
		SpringApplication.run(SnapGramSpringApplication.class, args);
        LOGGER.info("SnapGram application started successfully.");

	}

}
