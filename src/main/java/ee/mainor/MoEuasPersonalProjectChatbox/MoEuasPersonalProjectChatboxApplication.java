package ee.mainor.MoEuasPersonalProjectChatbox;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.h2.H2ConsoleAutoConfiguration;

//@SpringBootApplication
@SpringBootApplication(exclude = H2ConsoleAutoConfiguration.class)
public class MoEuasPersonalProjectChatboxApplication {

	public static void main(String[] args) {
		SpringApplication.run(MoEuasPersonalProjectChatboxApplication.class, args);
	}

}
