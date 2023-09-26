CREATE TABLE IF NOT EXISTS operations
(
    id BIGSERIAL PRIMARY KEY ,
    date DATE,
    description  VARCHAR(255),
    income INTEGER,
    outcome INTEGER,
    balance INTEGER
);