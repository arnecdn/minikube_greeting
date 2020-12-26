CREATE TABLE greeting
(
    id   BIGSERIAL primary key ,
    receiver VARCHAR(255),
    sender VARCHAR(255),
    message VARCHAR(4000),
    created timestamp
);