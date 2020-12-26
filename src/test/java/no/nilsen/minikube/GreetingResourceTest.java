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
            .when().get("/greeting/sample")
            .then()
            .statusCode(200)
            .body(is(notNullValue()));
    }

    @Test
    public void testCreateGreeting() {
        GreetingDto greetingDto = new GreetingDto("Anynomous", "Happy Christmas", "Anynomous");

        given()
            .contentType(ContentType.JSON)
            .body(greetingDto)
            .accept(ContentType.TEXT)
            .when()
            .post("/greeting")
            .then()
            .statusCode(200)
            .body(is(greetingDto.getMessage()));

        given()
            .accept(ContentType.JSON)
            .when()
            .get("/greeting")
            .then()
            .statusCode(200)
            .body(is(notNullValue()));

    }

}