package no.nilsen.minikube.api;

import java.time.LocalDateTime;

import no.nilsen.minikube.core.greeting.Greeting;

public class GreetingDto {
    private String greeting;
    private String from;

    public GreetingDto(final String greeting, final String from) {
        this.greeting = greeting;
        this.from = from;
    }

    public String getGreeting() {
        return greeting;
    }

    public String getFrom() {
        return from;
    }

    public static GreetingDto ofGreeting(final Greeting greeting) {
        return new GreetingDto(greeting.getMessage(), greeting.getCreatedBy());
    }

    public Greeting toGreeting() {
        return Greeting.GreetingBuilder.aGreeting().withMessage(this.getGreeting())
            .withCreatedBy(this.getFrom()).withCreated(LocalDateTime.now()).build();
    }
}
