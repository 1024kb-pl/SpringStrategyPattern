package pl.blog.spring.kb.SpringStrategyPattern.recipient.validation;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import pl.blog.spring.kb.SpringStrategyPattern.recipient.model.Recipient;
import pl.blog.spring.kb.SpringStrategyPattern.recipient.model.RecipientType;

import java.util.EnumMap;
import java.util.List;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;

@Component
@Slf4j
public class RecipientValidationService {
    private final EnumMap<RecipientType, RecipientValidator> validators;

    public RecipientValidationService(List<RecipientValidator> recipientValidators) {
        validators = recipientValidators.stream()
                .collect(Collectors.toMap(
                        RecipientValidator::getType,
                        Function.identity(),
                        detectDuplicatedImplementations(),
                        () -> new EnumMap<>(RecipientType.class)));
    }

    private BinaryOperator<RecipientValidator> detectDuplicatedImplementations() {
        return (l,r) -> {
            throw new RecipientValidationException("Found duplicated strategies assigned to one recipient type value: " + l.getClass() + " " + r.getClass());
        };
    }

    private RecipientValidator getValidator(RecipientType type) {
        return Optional.ofNullable(validators.get(type))
                .orElseThrow(() -> new RecipientValidationException(
                        "Validator for: " + type + " has not been found."
                ));
    }

    public void validate(Recipient recipient) {
        log.info("Validating recipient: {}", recipient);
        getValidator(recipient.getType())
                .validate(recipient);
    }

}
