CREATE TABLE IF NOT EXISTS Run (
    id INT NOT NULL,
    title VARCHAR(255) NOT NULL,
    startedOn TIMESTAMP NOT NULL,
    endedOn TIMESTAMP NOT NULL,
    miles INT NOT NULL,
    location VARCHAR(255) NOT NULL,
    PRIMARY KEY (id)
);