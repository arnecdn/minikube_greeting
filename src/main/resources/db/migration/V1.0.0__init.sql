CREATE TABLE quarkus
(
    id   BIGSERIAL primary key ,
    message VARCHAR(4000),
    created timestamp,
    created_by VARCHAR(255)
);