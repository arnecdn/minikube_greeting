package no.nilsen.minikube.infrastructure;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import no.nilsen.minikube.core.greeting.Greeting;

@Entity
@Table(name="greeting")
public class GreetingEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private long id;

    @Column(name="receiver")
    private String receiver;

    @Column(name="message")
    private String message;

    @Column(name="created")
    private LocalDateTime created;

    @Column(name="sender")
    private String sender;

    public String getMessage() {
        return message;
    }

    public static GreetingEntity ofGreeting(final Greeting greeting) {
        return GreetingEntity.GreetingEntityBuilder.aGreetingEntity()
            .withReceiver(greeting.getReceiver())
            .withMessage(greeting.getMessage())
            .withSender(greeting.getSender())
            .withCreated(greeting.getCreated())
            .build();
    }

    public Greeting toGreeting() {
        return Greeting.GreetingBuilder.aGreeting().withReceiver(this.receiver).withSender(this.sender).withMessage(this.getMessage()).build();
    }

    public static final class GreetingEntityBuilder {
        private long id;
        private String receiver;
        private String message;
        private LocalDateTime created;
        private String sender;

        private GreetingEntityBuilder() {}

        public static GreetingEntityBuilder aGreetingEntity() { return new GreetingEntityBuilder(); }

        public GreetingEntityBuilder withId(long id) {
            this.id = id;
            return this;
        }

        public GreetingEntityBuilder withReceiver(String receiver) {
            this.receiver = receiver;
            return this;
        }

        public GreetingEntityBuilder withMessage(String message) {
            this.message = message;
            return this;
        }

        public GreetingEntityBuilder withCreated(LocalDateTime created) {
            this.created = created;
            return this;
        }

        public GreetingEntityBuilder withSender(String sender) {
            this.sender = sender;
            return this;
        }

        public GreetingEntity build() {
            GreetingEntity greetingEntity = new GreetingEntity();
            greetingEntity.message = this.message;
            greetingEntity.id = this.id;
            greetingEntity.sender = this.sender;
            greetingEntity.receiver = this.receiver;
            greetingEntity.created = this.created;
            return greetingEntity;
        }
    }
}
