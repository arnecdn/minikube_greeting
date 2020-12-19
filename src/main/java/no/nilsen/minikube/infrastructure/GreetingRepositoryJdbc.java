package no.nilsen.minikube.infrastructure;

import java.util.List;
import java.util.stream.Collectors;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import no.nilsen.minikube.core.greeting.Greeting;
import no.nilsen.minikube.core.greeting.GreetingRepository;

@ApplicationScoped
public class GreetingRepositoryJdbc implements GreetingRepository, PanacheRepository<GreetingEntity> {

    @Override
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public void save(final Greeting greeting) {
        persist(GreetingEntity.GreetingEntityBuilder.aGreetingEntity()
            .withMessage(greeting.getMessage())
            .withCreatedBy(greeting.getCreatedBy())
            .withCreated(greeting.getCreated())
            .build()
        );
    }

    @Override
    public List<Greeting> fetchAll() {

        List<GreetingEntity> greetingEntities = listAll();
        return greetingEntities.stream().map(e -> {
            return Greeting.GreetingBuilder.aGreeting().withMessage(e.getMessage()).build();
        })
            .collect(Collectors.toList());
    }
}
