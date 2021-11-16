package practice.grap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class PracticeApplication {

	@Autowired
	ServiceObject serviceObject;

	public static void main(String[] args) {
		SpringApplication.run(PracticeApplication.class, args);
	}

	@PostConstruct
	@Transactional
	private void callsomething() {
		serviceObject.getData();

	}

}
