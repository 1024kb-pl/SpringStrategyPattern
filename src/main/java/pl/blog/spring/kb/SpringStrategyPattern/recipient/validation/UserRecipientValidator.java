package pl.blog.spring.kb.SpringStrategyPattern.recipient.validation;

import org.springframework.stereotype.Component;
import pl.blog.spring.kb.SpringStrategyPattern.recipient.model.Recipient;
import pl.blog.spring.kb.SpringStrategyPattern.recipient.model.RecipientType;

@Component
public class UserRecipientValidator implements RecipientValidator {
    private final static String USER_PREFIX = "user:";
    @Override
    public void validate(Recipient recipient) {
        if (!recipient.getValue().startsWith(USER_PREFIX)) {
            throw new RecipientValidationException("User recipient format is incorrect.");
        }
    }

    @Override
    public RecipientType getType() {
        return RecipientType.USER;
    }
}
