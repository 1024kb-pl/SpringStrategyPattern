package pl.blog.spring.kb.SpringStrategyPattern.recipient.validation;

import org.apache.commons.validator.routines.EmailValidator;
import org.springframework.stereotype.Component;
import pl.blog.spring.kb.SpringStrategyPattern.recipient.model.Recipient;
import pl.blog.spring.kb.SpringStrategyPattern.recipient.model.RecipientType;

@Component
public class EmailRecipientValidator implements RecipientValidator {
    @Override
    public void validate(Recipient recipient) {
        EmailValidator validator = EmailValidator.getInstance();

        if (!validator.isValid(recipient.getValue())) {
            throw new RecipientValidationException("Email format is incorrect.");
        }
    }

    @Override
    public RecipientType getType() {
        return RecipientType.EMAIL;
    }
}
