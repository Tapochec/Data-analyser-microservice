CREATE TABLE data
(
    id          BIGINT AUTO_INCREMENT PRIMARY KEY,
    sensor_id   BIGINT    NOT NULL,
    timestamp   TIMESTAMP NOT NULL,
    measurement FLOAT     NOT NULL,
    type        VARCHAR(255)   NOT NULL
);