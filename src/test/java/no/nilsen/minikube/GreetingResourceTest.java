package no.nilsen.minikube;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;

import static io.restassured.RestAssured.given;

import org.junit.jupiter.api.Test;

import io.quarkus.test.common.QuarkusTestResource;
import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;
import no.nilsen.minikube.api.GreetingDto;

@QuarkusTest
@QuarkusTestResource(PostgresResource.class)
public class GreetingResourceTest {


    @Test
    public void testHelloEndpoint() {
        given()
            .when().get("/hello-resteasy/sample")
            .then()
            .statusCode(200)
            .body(is("Hello RESTEasy"));
    }

    @Test
    public void testCreateGreeting() {
        GreetingDto greetingDto = new GreetingDto("God Jul", "arne");

        given()
            .contentType(ContentType.JSON)
            .body(greetingDto)
            .accept(ContentType.TEXT)
            .when()
            .post("/hello-resteasy")
            .then()
            .statusCode(200)
            .body(is(greetingDto.getGreeting()));

        given()
            .accept(ContentType.JSON)
            .when()
            .get("/hello-resteasy")
            .then()
            .statusCode(200)
            .body(is(notNullValue()));

    }

}