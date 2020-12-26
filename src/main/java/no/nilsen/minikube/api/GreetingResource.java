package no.nilsen.minikube.api;

import static no.nilsen.minikube.core.greeting.CreateGreeting.createGreeting;
import static no.nilsen.minikube.core.greeting.DeleteGreeting.deleteAllGreetings;
import static no.nilsen.minikube.core.greeting.QueryGreeting.finAllGreetings;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import javax.ejb.PostActivate;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import no.nilsen.minikube.core.greeting.Greeting;
import no.nilsen.minikube.core.greeting.GreetingRepository;
import no.nilsen.minikube.core.greeting.QueryGreeting;

@Path("/greeting")
public class GreetingResource {
    Logger LOGGER = Logger.getLogger(this.getClass().getName());

    @Inject
    GreetingRepository greetingRepo;

    @PostActivate
    public void starter(){
        LOGGER.log(Level.INFO,"Starter...");
    }

    @GET
    @Path("/sample")
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        LOGGER.log(Level.INFO,"Get sample");
        return "Hello RESTEasy";
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<GreetingDto> listGreetings() {
        List<Greeting> greetings = finAllGreetings(greetingRepo);
        LOGGER.log(Level.INFO,"List all greetings {0}", greetings);
        return greetings.stream()
            .map(GreetingDto::ofGreeting)
            .collect(Collectors.toList());
    }


    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public String hello(GreetingDto greetingDto) {
        LOGGER.log(Level.INFO,"Create greeting {0}", greetingDto.toString());

        createGreeting(greetingRepo, greetingDto.toGreeting());

        return greetingDto.getMessage();
    }

    @DELETE
    public String deleteAll(){
        long noGreetingsDeleted = deleteAllGreetings(greetingRepo);
        LOGGER.log(Level.INFO,"Deleted all greetings [{0}]", noGreetingsDeleted);
        return "All greetings are deleted";
    }
}