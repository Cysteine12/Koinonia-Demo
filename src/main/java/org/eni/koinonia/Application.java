package org.eni.koinonia;

import java.time.LocalDateTime;

import org.eni.koinonia.config.KoinoniaProperties;
import org.eni.koinonia.model.Transcript;
import org.eni.koinonia.model.TranscriptType;
import org.eni.koinonia.repository.TranscriptRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
// @EnableConfigurationProperties(KoinoniaProperties.class)
public class Application {

	private static final Logger log = LoggerFactory.getLogger(Application.class);

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);

		log.info("Application is running on port 8080");
	}

	/* @Bean
	CommandLineRunner commandLineRunner (TranscriptRepository transcriptRepository) {
		return args -> {
			Transcript transcript = new Transcript(
				"Worship Experience",
				"The fellowship of the Spirit",
				"https://koinonia.org/31e32rd1",
				TranscriptType.SPECIAL_SERVICE,
				LocalDateTime.now()
			);

			transcriptRepository.save(transcript);
		};
	} */

}
