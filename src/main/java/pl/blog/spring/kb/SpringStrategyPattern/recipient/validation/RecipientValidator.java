package pl.blog.spring.kb.SpringStrategyPattern.recipient.validation;

import pl.blog.spring.kb.SpringStrategyPattern.recipient.model.Recipient;
import pl.blog.spring.kb.SpringStrategyPattern.recipient.model.RecipientType;

interface RecipientValidator {
    void validate(Recipient recipient);
    RecipientType getType();
}
