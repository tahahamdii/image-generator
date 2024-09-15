package v1.openai;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class OpenaiApplication {

	public static void main(String[] args) {
		SpringApplication.run(OpenaiApplication.class, args);
	}



}
