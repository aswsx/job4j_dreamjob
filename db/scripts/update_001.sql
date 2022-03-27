CREATE TABLE IF NOT EXISTS post
(
    id   SERIAL PRIMARY KEY,
    name TEXT
);
CREATE TABLE IF NOT EXISTS candidate
(
    id   SERIAL PRIMARY KEY,
    name TEXT
);

CREATE TABLE IF NOT EXISTS users
(
    id       SERIAL PRIMARY KEY,
    email    TEXT,
    password TEXT
);

