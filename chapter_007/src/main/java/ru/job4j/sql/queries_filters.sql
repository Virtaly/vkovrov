CREATE DATABASE product_system;

CREATE TABLE types (
  id   SERIAL PRIMARY KEY,
  name CHARACTER VARYING(40)
);

CREATE TABLE products (
  id           SERIAL PRIMARY KEY,
  name         CHARACTER VARYING(40),
  type_id      INTEGER   NOT NULL,
  expired_date TIMESTAMP NOT NULL DEFAULT now(),
  price        INTEGER,
  FOREIGN KEY (type_id) REFERENCES types (id)
);

INSERT INTO types (name) VALUES ('СЫР');
INSERT INTO types (name) VALUES ('МОЛОКО');
INSERT INTO types (name) VALUES ('МОРОЖЕННОЕ');

INSERT INTO products (name, type_id, expired_date, price) VALUES ('Бельгийский сыр', '1', '2018-03-16 20:50:00', '100');
INSERT INTO products (name, type_id, expired_date, price) VALUES ('Английский сыр', '1', '2018-04-16 20:50:00', '200');
INSERT INTO products (name, type_id, expired_date, price) VALUES ('Голандский сыр', '1', '2018-05-16 20:50:00', '300');

INSERT INTO products (name, type_id, expired_date, price) VALUES ('Коровье молоко', '2', '2018-03-18 20:50:00', '50');
INSERT INTO products (name, type_id, expired_date, price) VALUES ('Козье молоко', '2', '2018-04-18 20:50:00', '100');
INSERT INTO products (name, type_id, expired_date, price) VALUES ('Овечье молоко', '2', '2018-05-18 20:50:00', '150');

INSERT INTO products (name, type_id, expired_date, price)
VALUES ('Ленинградское мороженное', '3', '2018-03-20 20:50:00', '30');
INSERT INTO products (name, type_id, expired_date, price)
VALUES ('Шоколадное мороженное', '3', '2018-04-20 20:50:00', '50');
INSERT INTO products (name, type_id, expired_date, price)
VALUES ('Ягодное мороженное', '3', '2018-05-20 20:50:00', '70');


--1. Написать запрос получение всех продуктов с типом "СЫР"
SELECT
  p.name,
  p.expired_date,
  p.price,
  t.name
FROM products AS p INNER JOIN types AS t ON p.type_id = t.id
WHERE t.name = 'СЫР';

--2. Написать запрос получения всех продуктов, у кого в имени есть слово "мороженное"
SELECT p.name
FROM products AS p
WHERE p.name LIKE '%мороженное%';

--3. Написать запрос, который выводит все продукты, срок годности которых заканчивается в следующем месяце.
SELECT
  p.name,
  p.expired_date
FROM products AS p
WHERE p.expired_date >= '2018-03-01 00:00:00' AND p.expired_date < '2018-04-01 00:00:00';

--4. Написать запрос, который вывод самый дорогой продукт.
SELECT *
FROM (SELECT
        ROW_NUMBER()
        OVER (
          ORDER BY products.price DESC )
          AS ROW,
        *
      FROM products) AS FOO
WHERE ROW = 1;

--5. Написать запрос, который выводит количество всех продуктов определенного типа.
SELECT
  t.name,
  count(p.type_id) AS prod_count
FROM products AS p INNER JOIN types AS t ON p.type_id = t.id
GROUP BY t.name;

--6. Написать запрос получение всех продуктов с типом "СЫР" и "МОЛОКО"
SELECT *
FROM products AS p INNER JOIN types AS t ON p.type_id = t.id
WHERE t.name = 'СЫР' OR t.name = 'МОЛОКО';

--7. Написать запрос, который выводит тип продуктов, которых осталось меньше 10 штук.
SELECT
  t.name,
  count(p.type_id) AS prod_count
FROM products AS p INNER JOIN types AS t ON p.type_id = t.id
GROUP BY t.name
HAVING count(p.type_id) < 10;

--8. Вывести все продукты и их тип.
SELECT *
FROM products
  INNER JOIN types ON products.type_id = types.id;