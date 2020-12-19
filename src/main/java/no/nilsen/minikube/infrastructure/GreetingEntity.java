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

    @Column(name="message")
    private String message;

    @Column(name="created")
    private LocalDateTime created;

    @Column(name="created_by")
    private String createdBy;

    public String getMessage() {
        return message;
    }

    public static GreetingEntity ofGreeting(final Greeting greeting) {
        return GreetingEntity.GreetingEntityBuilder.aGreetingEntity()
            .withMessage(greeting.getMessage())
            .withCreatedBy(greeting.getCreatedBy())
            .withCreated(greeting.getCreated())
            .build();
    }

    public Greeting toGreeting() {
        return Greeting.GreetingBuilder.aGreeting().withMessage(this.getMessage()).build();
    }

    public static final class GreetingEntityBuilder {
        private long id;
        private String message;
        private LocalDateTime created;
        private String createdBy;

        private GreetingEntityBuilder() {}

        public static GreetingEntityBuilder aGreetingEntity() { return new GreetingEntityBuilder(); }

        public GreetingEntityBuilder withMessage(String message) {
            this.message = message;
            return this;
        }

        public GreetingEntityBuilder withCreated(LocalDateTime created) {
            this.created = created;
            return this;
        }

        public GreetingEntityBuilder withCreatedBy(String createdBy) {
            this.createdBy = createdBy;
            return this;
        }

        public GreetingEntity build() {
            GreetingEntity greetingEntity = new GreetingEntity();
            greetingEntity.message = this.message;
            greetingEntity.id = this.id;
            greetingEntity.created = this.created;
            greetingEntity.createdBy = this.createdBy;
            return greetingEntity;
        }
    }

}
