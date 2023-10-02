-- -----------------------------------------------------
-- `MOVIE TYPE`
-- -----------------------------------------------------

INSERT INTO movie_type (id, genre, period_price, penalty, allowed_rental_days, daily_wage)
VALUES ('9fad775f-e3a6-41be-92f2-cbd72b7e24fb', 'REGULAR', '2', '1.5', '2', 'false');

INSERT INTO movie_type (id, genre, daily_price, daily_wage)
VALUES ('4e77635c-b3ae-478a-b0e8-5dfd929a7f01', 'NEW_RELEASE', '3', 'true');

INSERT INTO movie_type (id, genre, period_price, penalty, allowed_rental_days, daily_wage)
VALUES ('efb2f5de-c3e2-4056-a949-e84db49f7ba0', 'CHILDRENS', '1.5', '1.5', '3', 'false');


-- -----------------------------------------------------
-- `MOVIE`
-- -----------------------------------------------------

INSERT INTO movie (id, title, movie_type_id)
VALUES ('e6923c19-b0f9-4e2b-a3a7-e67e305e0ffa', 'Rambo', '9fad775f-e3a6-41be-92f2-cbd72b7e24fb');

INSERT INTO movie (id, title, movie_type_id)
VALUES ('29b5d1af-fe6e-499f-a039-914295c63fe4', 'Lord of the Rings', '4e77635c-b3ae-478a-b0e8-5dfd929a7f01');

INSERT INTO movie (id, title, movie_type_id)
VALUES ('0ea0a09f-98d2-4491-8608-a68cb8001974', 'Harry Potter', 'efb2f5de-c3e2-4056-a949-e84db49f7ba0');


-- -----------------------------------------------------
-- `CUSTOMER`
-- -----------------------------------------------------

INSERT INTO customer (id, name, frequent_renter_point)
VALUES ('f263c4d9-b198-48c4-a97b-34cbb8387379', 'John Doe', '0');


-- -----------------------------------------------------
-- `RENTAL`
-- -----------------------------------------------------

INSERT INTO rental (id, open, movie_id, rented_date, customer_id)
VALUES ('df2d8a49-e706-4e2a-a9c1-357eab348737', 'true', 'e6923c19-b0f9-4e2b-a3a7-e67e305e0ffa', '2023-10-01', 'f263c4d9-b198-48c4-a97b-34cbb8387379');

INSERT INTO rental (id, open, movie_id, rented_date, customer_id)
VALUES ('38a4b68b-dd79-48b2-b83f-67f9d5ae9693', 'true', '29b5d1af-fe6e-499f-a039-914295c63fe4', '2023-09-28', 'f263c4d9-b198-48c4-a97b-34cbb8387379');

INSERT INTO rental (id, open, movie_id, rented_date, customer_id)
VALUES ('435b7b65-e6d7-427a-9668-11ad2531e559', 'true', '0ea0a09f-98d2-4491-8608-a68cb8001974', '2023-09-27', 'f263c4d9-b198-48c4-a97b-34cbb8387379');
