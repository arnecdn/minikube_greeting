package no.nilsen.minikube.core.greeting;

import java.time.LocalDateTime;

public class Greeting {
    private long id;
    private String message;
    private LocalDateTime created;
    private String createdBy;

    public long getId() {
        return id;
    }

    public String getMessage() {
        return message;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public static final class GreetingBuilder {
        private long id;
        private String message;
        private LocalDateTime created;
        private String createdBy;

        private GreetingBuilder() {}

        public static GreetingBuilder aGreeting() { return new GreetingBuilder(); }

        public GreetingBuilder withId(long id) {
            this.id = id;
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

        public GreetingBuilder withCreatedBy(String createdBy) {
            this.createdBy = createdBy;
            return this;
        }

        public Greeting build() {
            Greeting greeting = new Greeting();
            greeting.id = this.id;
            greeting.createdBy = this.createdBy;
            greeting.message = this.message;
            greeting.created = this.created;
            return greeting;
        }
    }
}
