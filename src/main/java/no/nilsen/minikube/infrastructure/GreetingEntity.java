package no.nilsen.minikube.infrastructure;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

@Entity
public class GreetingEntity  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
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

    public static final class GreetingEntityBuilder {
        private long id;
        private String message;
        private LocalDateTime created;
        private String createdBy;

        private GreetingEntityBuilder() {}

        public static GreetingEntityBuilder aGreetingEntity() { return new GreetingEntityBuilder(); }

        public GreetingEntityBuilder withId(long id) {
            this.id = id;
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
