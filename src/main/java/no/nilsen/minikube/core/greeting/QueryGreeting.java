package no.nilsen.minikube.core.greeting;

import java.util.List;

public class QueryGreeting {

    public static List<Greeting> finAllGreetings( GreetingRepository greetingRepository){
        return greetingRepository.fetchAll();
    }
}
