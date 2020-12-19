package no.nilsen.minikube;

import java.util.Collections;
import java.util.Map;

import org.testcontainers.containers.PostgreSQLContainer;

import io.quarkus.test.common.QuarkusTestResourceLifecycleManager;

public class PostgresResource implements
    QuarkusTestResourceLifecycleManager {

    static final PostgreSQLContainer<?> db =
        new PostgreSQLContainer<>("postgres:13")
            //.withDatabaseName("greeting-db")
            .withUsername("greeting")
            .withPassword("greeting")
        ;

    @Override
    public Map<String, String> start() {
        db.start();
        return Collections.singletonMap(
            "quarkus.datasource.jdbc.url", db.getJdbcUrl()
        );
    }

    @Override
    public void stop() {
        db.stop();
    }
}
