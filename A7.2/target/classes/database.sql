-- 1
DROP DATABASE IF EXISTS currencydb;

-- 2
CREATE DATABASE currencydb;

USE currencydb;

-- 3
CREATE TABLE Currency (
    id INT AUTO_INCREMENT PRIMARY KEY,
    abbreviation VARCHAR(3) NOT NULL UNIQUE,
    name VARCHAR(50) NOT NULL,
    exchange_rate DECIMAL(15, 6) NOT NULL
);

-- 4
INSERT INTO Currency (abbreviation, name, exchange rate) VALUES
    ('EUR', 'Euro', 0.86619172),
    ('GBP', 'British Pound', 0.74148699),
    ('JPY', 'Japanese Yen', 157.13226114),
    ('PLN', 'Polish Zloty', 3.73213674),
    ('CAD', 'Canadian Dollar', 1.40153399),
    ('AUD', 'Australian Dollar', 1.41918065),
    ('CNY', 'Chinese Yuan', 6.75159232),
    ('VND', 'Vietnamese Dong', 25000.000000);

--5
DROP USER IF EXISTS 'appuser'@'localhost';


-- 6
CREATE USER 'appuser'@'localhost' IDENTIFIED BY '1111';

-- 7
GRANT SELECT ON currencydb.* TO 'appuser'@'localhost';
FLUSH PRIVILEGES;