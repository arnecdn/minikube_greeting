package no.nilsen.minikube.core.greeting;

import java.util.List;

public class QueryGreeting {
    private GreetingRepository greetingRepository;

    public List<Greeting> listGreetings(){

        return greetingRepository.fetchAll();
    }
}
