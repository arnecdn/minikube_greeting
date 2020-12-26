package no.nilsen.minikube.api;

import java.time.LocalDateTime;
import java.util.StringJoiner;

import no.nilsen.minikube.core.greeting.Greeting;

public class GreetingDto {
    public GreetingDto(final String to, final String message, final String from) {
        this.to = to;
        this.message = message;
        this.from = from;
    }

    private String to;
    private String message;
    private String from;

    public GreetingDto() {
    }


    public String getTo() {
        return to;
    }

    public String getMessage() {
        return message;
    }

    public String getFrom() {
        return from;
    }

    public static GreetingDto ofGreeting(final Greeting greeting) {
        return new GreetingDto(greeting.getReceiver(),
            greeting.getMessage(),
            greeting.getSender());
    }

    public Greeting toGreeting() {
        return Greeting.GreetingBuilder.aGreeting()
            .withReceiver(this.to)
            .withMessage(this.getMessage())
            .withSender(this.getFrom())
            .withCreated(LocalDateTime.now()).build();
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", GreetingDto.class.getSimpleName() + "[", "]")
            .add("to='" + to + "'")
            .add("message='" + message + "'")
            .add("from='" + from + "'")
            .toString();
    }
}
