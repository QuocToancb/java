package practice.transactionP;

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
		serviceObject.updateAuthorName(1l, "2");
//		serviceObject.propagationMandatory(3l, "2");

	}

}
