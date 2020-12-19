package no.nilsen.minikube.api;

public class GreetingDto {
    private String greeting;
    private String from;

    public GreetingDto(final String greeting, final String from) {
        this.greeting = greeting;
        this.from = from;
    }

    public GreetingDto() {
    }

    public void setGreeting(final String greeting) {
        this.greeting = greeting;
    }

    public void setFrom(final String from) {
        this.from = from;
    }

    public String getGreeting() {
        return greeting;
    }

    public String getFrom() {
        return from;
    }
}
