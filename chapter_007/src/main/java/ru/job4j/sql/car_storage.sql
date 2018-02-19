CREATE TABLE engine (
  id   SERIAL PRIMARY KEY,
  name CHARACTER VARYING(40)
);

CREATE TABLE transmission (
  id   SERIAL PRIMARY KEY,
  name CHARACTER VARYING(40)
);

CREATE TABLE gearbox (
  id   SERIAL PRIMARY KEY,
  name CHARACTER VARYING(40)
);

CREATE TABLE car (
  id              SERIAL PRIMARY KEY,
  name            CHARACTER VARYING(40),
  engine_id       INTEGER NOT NULL,
  transmission_id INTEGER NOT NULL,
  gearbox_id      INTEGER NOT NULL,
  FOREIGN KEY (engine_id) REFERENCES engine (id),
  FOREIGN KEY (transmission_id) REFERENCES transmission (id),
  FOREIGN KEY (gearbox_id) REFERENCES gearbox (id)
);

INSERT INTO engine (name) VALUES ('Бензиновый двигатель');
INSERT INTO engine (name) VALUES ('Дизельный двигатель');
INSERT INTO engine (name) VALUES ('Роторно-поршневой двигатель');
INSERT INTO engine (name) VALUES ('Гибридная силовая установка');

INSERT INTO transmission (name) VALUES ('Механическая трансмиссия');
INSERT INTO transmission (name) VALUES ('Роботизированная трансмиссия');
INSERT INTO transmission (name) VALUES ('Автоматическая трансмиссия');
INSERT INTO transmission (name) VALUES ('Бесступенчатая трансмиссия');

INSERT INTO gearbox (name) VALUES ('Механическая коробка передач');
INSERT INTO gearbox (name) VALUES ('Роботизированная коробка передач');
INSERT INTO gearbox (name) VALUES ('Автоматическая коробка передач');
INSERT INTO gearbox (name) VALUES ('Бесступенчатая коробка передач');
INSERT INTO gearbox (name) VALUES ('Коробка передач с двойным сцеплением');
INSERT INTO gearbox (name) VALUES ('Односкоростная коробка передач');
INSERT INTO gearbox (name) VALUES ('Полуавтоматическая коробка передач');
INSERT INTO gearbox (name) VALUES ('Коробка передач IVT');

INSERT INTO car (name, engine_id, transmission_id, gearbox_id) VALUES ('Porche', '3', '2', '5');
INSERT INTO car (name, engine_id, transmission_id, gearbox_id) VALUES ('Lada', '1', '1', '1');
INSERT INTO car (name, engine_id, transmission_id, gearbox_id) VALUES ('Tesla', '4', '3', '3');

--Вывести все машины.
SELECT
  c.name,
  e.name,
  t.name,
  g.name
FROM car AS c INNER JOIN engine AS e ON c.engine_id = e.id
  INNER JOIN transmission t ON c.transmission_id = t.id
  INNER JOIN gearbox g ON c.gearbox_id = g.id;

--Вывести все неиспользуемые детали.
SELECT e.name AS not_used_details
FROM car AS c RIGHT OUTER JOIN engine AS e ON c.engine_id = e.id
WHERE c.id ISNULL
UNION
SELECT t.name
FROM car AS c RIGHT OUTER JOIN transmission t ON c.transmission_id = t.id
WHERE c.id ISNULL
UNION
SELECT g.name
FROM car AS c RIGHT OUTER JOIN gearbox g ON c.gearbox_id = g.id
WHERE c.id ISNULL;