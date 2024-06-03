package mailaka.management.webService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class WebServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebServiceApplication.class, args);
	}

}
