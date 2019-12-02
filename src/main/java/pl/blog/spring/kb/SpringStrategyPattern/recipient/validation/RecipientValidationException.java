package pl.blog.spring.kb.SpringStrategyPattern.recipient.validation;

public class RecipientValidationException extends RuntimeException {
    RecipientValidationException(String s) {
        super(s);
    }
}
