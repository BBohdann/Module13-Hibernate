CREATE TABLE client (
id SERIAL PRIMARY KEY,
name VARCHAR (200) NOT NULL CHECK((CHAR_LENGTH(NAME) between 3 and 200))
);

CREATE TABLE planet (
    id VARCHAR(10) PRIMARY KEY CHECK (id ~ '^[A-Z0-9]*$'),
    name VARCHAR(500) NOT NULL
);

CREATE TABLE ticket (
    id SERIAL PRIMARY KEY,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    client_id BIGINT,
    from_planet_id VARCHAR(10) CHECK (from_planet_id ~ '^[A-Z0-9]*$'),
    to_planet_id VARCHAR(10) CHECK (to_planet_id ~ '^[A-Z0-9]*$'),
    FOREIGN KEY (client_id) REFERENCES client(id),
    FOREIGN KEY (from_planet_id) REFERENCES planet(id),
    FOREIGN KEY (to_planet_id) REFERENCES planet(id)
);