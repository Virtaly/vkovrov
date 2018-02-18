CREATE DATABASE items_system;

CREATE TABLE users (
  id          SERIAL PRIMARY KEY,
  name        CHARACTER VARYING(20),
  surname     CHARACTER VARYING(20),
  create_date TIMESTAMP NOT NULL DEFAULT now()
);

CREATE TABLE roles (
  id      SERIAL PRIMARY KEY,
  role    CHARACTER VARYING(20),
  user_id INTEGER NOT NULL,
  FOREIGN KEY (user_id) REFERENCES users (id)
);

CREATE TABLE rules (
  id   SERIAL PRIMARY KEY,
  rule TEXT
);

CREATE TABLE role_rule (
  role_id INTEGER NOT NULL,
  rule_id INTEGER NOT NULL,
  PRIMARY KEY (role_id, rule_id),
  FOREIGN KEY (role_id) REFERENCES roles (id),
  FOREIGN KEY (rule_id) REFERENCES rules (id)
);

CREATE TABLE categories (
  id          SERIAL PRIMARY KEY,
  name        CHARACTER VARYING(20),
  description TEXT
);

CREATE TABLE states (
  id          SERIAL PRIMARY KEY,
  name        CHARACTER VARYING(20),
  description TEXT
);

CREATE TABLE items (
  id          SERIAL PRIMARY KEY,
  item        TEXT,
  category_id INTEGER NOT NULL,
  state_id    INTEGER NOT NULL,
  create_date TIMESTAMP NOT NULL DEFAULT now(),
  FOREIGN KEY (id) REFERENCES users (id),
  FOREIGN KEY (category_id) REFERENCES categories (id),
  FOREIGN KEY (state_id) REFERENCES states (id)
);

CREATE TABLE comments (
  id          SERIAL PRIMARY KEY,
  name        CHARACTER VARYING(20),
  description TEXT,
  item_id     INTEGER,
  FOREIGN KEY (item_id) REFERENCES items (id)
);

CREATE TABLE attachs (
  id      SERIAL PRIMARY KEY,
  name    CHARACTER VARYING(20),
  source  TEXT,
  item_id INTEGER,
  FOREIGN KEY (item_id) REFERENCES items (id)
);

INSERT INTO users (name, surname, create_date) VALUES ('Vitaliy', 'Kovrov', '2018-02-16 20:50:00');
INSERT INTO users (name, surname, create_date) VALUES ('Michail', 'Gusarov', '2018-02-16 20:55:00');

INSERT INTO roles (role, user_id) VALUES ('Administrator', '2');
INSERT INTO roles (role, user_id) VALUES ('Programmer', '1');

INSERT INTO rules (rule) VALUES ('All access');
INSERT INTO rules (rule) VALUES ('Access to developing tools');

INSERT INTO role_rule (role_id, rule_id) VALUES ('1', '1');
INSERT INTO role_rule (role_id, rule_id) VALUES ('2', '2');

INSERT INTO categories (name, description) VALUES ('Very important', 'Make as soon as possible');
INSERT INTO categories (name, description) VALUES ('Middle important', 'Make as possible');

INSERT INTO states (name, description) VALUES ('Is not completed', 'Is not completed yet');
INSERT INTO states (name, description) VALUES ('Completed', 'Already completed');

INSERT INTO items (item, category_id, state_id, create_date) VALUES ('Fix bugs', '1', '2', '2018-02-17 20:55:00');
INSERT INTO items (item, category_id, state_id, create_date)
VALUES ('Add new feature', '2', '1', '2018-02-17 21:55:00');

INSERT INTO comments (name, description, item_id) VALUES ('Bugs', 'Our tester found some bugs', 1);
INSERT INTO comments (name, description, item_id) VALUES ('Bugs', 'Please fix it', 1);
INSERT INTO comments (name, description, item_id) VALUES ('Feature', 'Our client wants new feature', 2);
INSERT INTO comments (name, description, item_id) VALUES ('Feature', 'Do it when it is time', 2);

INSERT INTO attachs (name, source, item_id) VALUES ('BugReport', 'C:/AppData/bugReport.txt', '1');
INSERT INTO attachs (name, source, item_id) VALUES ('ReadMe', 'C:/AppData/readMe.txt', '2');
