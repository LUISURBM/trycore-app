DROP TABLE planets IF EXISTS;
DROP TABLE persons IF EXISTS;


CREATE TABLE persons (
  id         INTEGER IDENTITY PRIMARY KEY,
  first_name VARCHAR(2000),
  planet  VARCHAR(2000),
  contador   INTEGER
);
CREATE INDEX persons_first_name ON persons (first_name);

CREATE TABLE planets (
  id   INTEGER IDENTITY PRIMARY KEY,
  first_name VARCHAR(2000),
  dfekm VARCHAR(2000),
  ntkap VARCHAR(2000),
  contador   INTEGER
);
CREATE INDEX planets_first_name ON planets (first_name);

