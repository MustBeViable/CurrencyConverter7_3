SELECT * FROM currency;

SELECT * FROM currency
WHERE currency_code = 'EUR';

SELECT COUNT(*) AS currency_count
FROM currency;

SELECT *
FROM currency
ORDER BY rate_to_jpy DESC
    LIMIT 1;