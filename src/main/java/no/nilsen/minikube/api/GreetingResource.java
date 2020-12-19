package no.nilsen.minikube.api;

import static no.nilsen.minikube.core.greeting.CreateGreeting.createGreeting;

import java.time.LocalDateTime;
import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import no.nilsen.minikube.core.greeting.CreateGreeting;
import no.nilsen.minikube.core.greeting.Greeting;
import no.nilsen.minikube.core.greeting.GreetingRepository;

@Path("/hello-resteasy")
public class GreetingResource {

    @Inject
    GreetingRepository greetingRepo;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "Hello RESTEasy";
    }


    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public String hello(GreetingDto greetingDto) {

        Greeting greeting = Greeting.GreetingBuilder.aGreeting().withMessage(greetingDto.getGreeting())
            .withCreatedBy(greetingDto.getFrom()).withCreated(LocalDateTime.now()).build();

        createGreeting(greetingRepo, greeting);

        return greetingDto.getGreeting();
    }
}