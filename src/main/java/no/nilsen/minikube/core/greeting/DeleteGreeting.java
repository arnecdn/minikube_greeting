package no.nilsen.minikube.core.greeting;

public class DeleteGreeting {
    private DeleteGreeting() {
    }

    public static long deleteAllGreetings(final GreetingRepository greetingRepository) {
        return greetingRepository.deleteAllGreetings();
    }

}
