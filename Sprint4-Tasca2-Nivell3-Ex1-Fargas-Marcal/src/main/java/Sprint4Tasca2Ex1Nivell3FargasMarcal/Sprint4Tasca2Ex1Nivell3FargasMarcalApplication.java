package Sprint4Tasca2Ex1Nivell3FargasMarcal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;


//@SpringBootApplication
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class Sprint4Tasca2Ex1Nivell3FargasMarcalApplication {

	public static void main(String[] args) {
		SpringApplication.run(Sprint4Tasca2Ex1Nivell3FargasMarcalApplication.class, args);
	}

}
