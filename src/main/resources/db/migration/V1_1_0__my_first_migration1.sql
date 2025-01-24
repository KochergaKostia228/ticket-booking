CREATE TABLE IF NOT EXISTS Customers (
    id SERIAL PRIMARY KEY,
    name character varying(30),
    email varchar (30),
    phone varchar (30)
);

CREATE TABLE IF NOT EXISTS Places(
    id SERIAL PRIMARY KEY,
    address varchar (30),
    name character varying(30)
);

CREATE TABLE Events (
    id SERIAL PRIMARY KEY,
    event_date TIMESTAMP ,
    name VARCHAR(255),
    place_id INTEGER,

    FOREIGN KEY (place_id) REFERENCES places(id) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS Tickets (
    id SERIAL PRIMARY KEY,
    cost money,
    number INTEGER,
    customer_id INTEGER,
    event_id INTEGER,
    status VARCHAR(20),

    FOREIGN KEY (customer_id) REFERENCES Customers(id) ON DELETE CASCADE,
    FOREIGN KEY (event_id) REFERENCES Events(id) ON DELETE CASCADE
);

