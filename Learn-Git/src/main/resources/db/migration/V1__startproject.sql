CREATE TABLE cars(
   vehicle_identification_number varchar(30),
   marca varchar(30),
   plate_number varchar(7) UNIQUE,
   fabrication_date timestamp,
   price int,
   PRIMARY KEY(vehicle_identification_number)
);

CREATE TABLE users(
    username varchar(30),
    password varchar(256),
    role VARCHAR(20),
    PRIMARY KEY(username)
);

INSERT INTO cars values('4Y2-SL658-4-8-Z-41', 'AUDI A6', 'CJ07ABC', '2022-04-04 11:33:30', 20000);
INSERT INTO cars values('4Y1-JR658-4-8-Z-41', 'AUDI A8', 'CJ17DDD', '2022-04-04 11:33:30', 30000);
INSERT INTO cars values('4Y4-SL658-4-9-Z-41', 'BMW', 'CJ99CCE', '2019-05-22 11:33:30', 30000);
INSERT INTO cars values('4Y1-SL658-4-8-Z-33', 'Volkswagen Passat', 'CJ07JAR', '2016-10-09 11:33:30', 10000);
INSERT INTO cars values('4Y1-AL658-4-7-Z-41', 'Opel Astra', 'CJ15WWW', '2015-03-14 11:33:30', 18000);
INSERT INTO cars values('4Z5-CV658-4-8-Z-41', 'BMW Seria 2', 'CJ33CCC', '2014-07-05 11:33:30', 23000);