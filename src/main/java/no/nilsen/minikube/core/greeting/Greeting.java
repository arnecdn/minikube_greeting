package no.nilsen.minikube.core.greeting;

import java.time.LocalDateTime;
import java.util.StringJoiner;

public class Greeting {
    private long id;
    private String receiver;
    private String message;
    private LocalDateTime created;
    private String sender;

    public String getReceiver() {
        return receiver;
    }

    public String getMessage() {
        return message;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public String getSender() {
        return sender;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Greeting.class.getSimpleName() + "[", "]")
            .add("id=" + id)
            .add("receiver='" + receiver + "'")
            .add("message='" + message + "'")
            .add("created=" + created)
            .add("sender='" + sender + "'")
            .toString();
    }

    public static final class GreetingBuilder {
        private long id;
        private String receiver;
        private String message;
        private LocalDateTime created;
        private String sender;

        private GreetingBuilder() {}

        public static GreetingBuilder aGreeting() { return new GreetingBuilder(); }

        public GreetingBuilder withId(long id) {
            this.id = id;
            return this;
        }

        public GreetingBuilder withReceiver(String to) {
            this.receiver = to;
            return this;
        }

        public GreetingBuilder withMessage(String message) {
            this.message = message;
            return this;
        }

        public GreetingBuilder withCreated(LocalDateTime created) {
            this.created = created;
            return this;
        }

        public GreetingBuilder withSender(String createdBy) {
            this.sender = createdBy;
            return this;
        }

        public Greeting build() {
            Greeting greeting = new Greeting();
            greeting.created = this.created;
            greeting.message = this.message;
            greeting.sender = this.sender;
            greeting.id = this.id;
            greeting.receiver = this.receiver;
            return greeting;
        }
    }
}
