package pl.blog.spring.kb.SpringStrategyPattern.recipient.validation;

import org.springframework.stereotype.Component;
import pl.blog.spring.kb.SpringStrategyPattern.recipient.model.Recipient;
import pl.blog.spring.kb.SpringStrategyPattern.recipient.model.RecipientType;

@Component
public class FieldRecipientValidator implements RecipientValidator {
    private final static String FIELD_PREFIX = "field:";
    @Override
    public void validate(Recipient recipient) {
        if (!recipient.getValue().startsWith(FIELD_PREFIX)) {
            throw new RecipientValidationException("Field recipient format is incorrect.");
        }
    }

    @Override
    public RecipientType getType() {
        return RecipientType.FIELD;
    }
}
