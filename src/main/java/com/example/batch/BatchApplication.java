package com.example.batch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BatchApplication {

	public static final String URL_MARVEL = "https://gateway.marvel.com:443/v1/public/characters";

	public static final String AUTH_MARVEL = "?ts=1&apikey=67547511c23a2354bedcdae4f50d38de&hash=a89c048cefd768d174c86eca60c3fd67";

	public static final String FILES_PATH = "./src/main/java/com/example/batch/files/output";

	public static void main(String[] args) {
		SpringApplication.run(BatchApplication.class, args);
	}

}
