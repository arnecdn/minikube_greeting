package no.nilsen.minikube.core.greeting;

import java.util.List;

public interface GreetingRepository {
    void save(Greeting greeting);

    List<Greeting> fetchAll();
}
