package pl.blog.spring.kb.SpringStrategyPattern;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pl.blog.spring.kb.SpringStrategyPattern.recipient.RecipientService;
import pl.blog.spring.kb.SpringStrategyPattern.recipient.model.Recipient;
import pl.blog.spring.kb.SpringStrategyPattern.recipient.model.RecipientType;

@SpringBootApplication
public class SpringStrategyPatternApplication implements CommandLineRunner {

	private final RecipientService recipientService;

	public SpringStrategyPatternApplication(RecipientService recipientService) {
		this.recipientService = recipientService;
	}


	public static void main(String[] args) {
		SpringApplication.run(SpringStrategyPatternApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		recipientService.createRecipient(new Recipient(RecipientType.USER, "user:pablo"));
		recipientService.createRecipient(new Recipient(RecipientType.EMAIL, "qwe@wp.pl"));
		recipientService.createRecipient(new Recipient(RecipientType.USER, "pablofail"));
		recipientService.createRecipient(new Recipient(RecipientType.FIELD, "fiel:pole"));
		recipientService.createRecipient(new Recipient(RecipientType.FIELD, "field:pole"));
	}
}
