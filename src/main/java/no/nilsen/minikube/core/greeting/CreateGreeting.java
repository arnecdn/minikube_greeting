package no.nilsen.minikube.core.greeting;

public class CreateGreeting {
    private CreateGreeting() {
    }

    public static void createGreeting(final GreetingRepository greetingRepository, Greeting newGreeting) {
        greetingRepository.save(newGreeting);
    }

}
