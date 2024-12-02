DROP DATABASE IF EXISTS `travel_24_12`;
CREATE DATABASE `travel_24_12`;
USE `travel_24_12`;



CREATE TABLE tourist (
                         id INT AUTO_INCREMENT PRIMARY KEY,
                         name VARCHAR(255),
                         description TEXT,
                         latitude DOUBLE,
                         longitude DOUBLE
);

CREATE TABLE weather (
                         id INT AUTO_INCREMENT PRIMARY KEY,
                         city_name VARCHAR(255),
                         temperature DOUBLE,
                         humidity INT,
                         tourist_id INT,
                         FOREIGN KEY (tourist_id) REFERENCES tourist(id)
);