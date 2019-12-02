package pl.blog.spring.kb.SpringStrategyPattern.recipient.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@RequiredArgsConstructor
@Getter
@ToString
public class Recipient {
    private final RecipientType type;
    private final String value;
}
