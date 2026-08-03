USE currencydb;

-- 1
SELECT * FROM Currency;

-- 2
SELECT * FROM Currency WHERE abbreviation = 'EUR';

-- 3
SELECT COUNT(*) AS number_of_currencies FROM Currency;

-- 4
SELECT * FROM Currency WHERE exchange_rate = (
    SELECT MAX(exchange_rate)
    FROM Currency
);