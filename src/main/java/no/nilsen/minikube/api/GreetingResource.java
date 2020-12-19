package no.nilsen.minikube.api;

import static no.nilsen.minikube.core.greeting.CreateGreeting.createGreeting;

import java.util.List;
import java.util.stream.Collectors;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import no.nilsen.minikube.core.greeting.Greeting;
import no.nilsen.minikube.core.greeting.GreetingRepository;
import no.nilsen.minikube.core.greeting.QueryGreeting;

@Path("/hello-resteasy")
public class GreetingResource {

    @Inject
    GreetingRepository greetingRepo;

    @GET
    @Path("/sample")
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "Hello RESTEasy";
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<GreetingDto> listGreetings() {
        List<Greeting> greetings = QueryGreeting.finAllGreetings(greetingRepo);
        return greetings.stream()
            .map(GreetingDto::ofGreeting)
            .collect(Collectors.toList());
    }


    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public String hello(GreetingDto greetingDto) {

        createGreeting(greetingRepo, greetingDto.toGreeting());

        return greetingDto.getGreeting();
    }
}