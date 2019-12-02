package pl.blog.spring.kb.SpringStrategyPattern.recipient;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import pl.blog.spring.kb.SpringStrategyPattern.recipient.model.Recipient;
import pl.blog.spring.kb.SpringStrategyPattern.recipient.validation.RecipientValidationException;
import pl.blog.spring.kb.SpringStrategyPattern.recipient.validation.RecipientValidationService;

@Component
@Slf4j
@RequiredArgsConstructor
public class RecipientService {
    private final RecipientValidationService recipientValidatorService;

    public void createRecipient(Recipient recipient) {
        try {
            recipientValidatorService.validate(recipient);
            log.info("Recipient has been created: {}.", recipient);
        } catch (RecipientValidationException e) {
            log.error(e.getMessage(), e);
        }
    }
}
