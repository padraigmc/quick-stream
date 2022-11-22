SELECT 'CREATE DATABASE quickstream'
WHERE NOT EXISTS (SELECT FROM pg_database WHERE datname = 'quickstream')\gexec

CREATE TABLE IF NOT EXISTS videos (
    id serial PRIMARY KEY,
    name varchar(50) NOT NULL,
    path varchar(50) NOT NULL
);