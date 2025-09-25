DROP DATABASE IF EXISTS currencyconverter;
CREATE DATABASE currencyconverter;
USE currencyconverter;

DROP TABLE IF EXISTS currency;

CREATE TABLE currency (
                          id INT NOT NULL AUTO_INCREMENT,
                          currency_code VARCHAR(3) NOT NULL,
                          currency_name VARCHAR(50) NOT NULL,
                          rate_to_usd DOUBLE,
                          rate_to_gbp DOUBLE,
                          rate_to_eur DOUBLE,
                          rate_to_jpy DOUBLE,
                          rate_to_chf DOUBLE,
                          rate_to_cad DOUBLE,
                          rate_to_aud DOUBLE,
                          rate_to_sgd DOUBLE,
                          PRIMARY KEY (id),
                          UNIQUE KEY uq_currency_code (currency_code)
);

INSERT INTO currency
(currency_code, currency_name,
 rate_to_usd, rate_to_gbp, rate_to_eur, rate_to_jpy, rate_to_chf, rate_to_cad, rate_to_aud, rate_to_sgd)
VALUES
    ('USD','US Dollar',
     1.00000000, 0.74199046, 0.85207907, 148.08282209, 0.79618269, 1.38156101, 1.51687117, 1.28502045),
    ('EUR','Euro',
     1.17360000, 0.87080000, 1.00000000, 173.79000000, 0.93440000, 1.62140000, 1.78020000, 1.50810000),
    ('GBP','Pound sterling',
     1.34772623, 1.00000000, 1.14836932, 199.57510335, 1.07303629, 1.86196601, 2.04432706, 1.73185576),
    ('JPY','Japanese yen',
     0.00675298, 0.00501065, 0.00575407, 1.00000000, 0.00537660, 0.00932965, 0.01024340, 0.00867771),
    ('CHF','Swiss franc',
     1.25599315, 0.93193493, 1.07020548, 185.99101027, 1.00000000, 1.73523116, 1.90517979, 1.61397688),
    ('CAD','Canadian dollar',
     0.72381892, 0.53706673, 0.61675096, 107.18514864, 0.57629209, 1.00000000, 1.09794005, 0.93012212),
    ('AUD','Australian dollar',
     0.65925177, 0.48915852, 0.56173464, 97.62386249, 0.52488484, 0.91079654, 1.00000000, 0.84715201),
    ('SGD','Singapore dollar',
     0.77819773, 0.57741529, 0.66308600, 115.23771633, 0.61958756, 1.07512764, 1.18042570, 1.00000000)

    ON DUPLICATE KEY UPDATE
                         currency_name = VALUES(currency_name),
                         rate_to_usd   = VALUES(rate_to_usd),
                         rate_to_gbp   = VALUES(rate_to_gbp),
                         rate_to_eur   = VALUES(rate_to_eur),
                         rate_to_jpy   = VALUES(rate_to_jpy),
                         rate_to_chf   = VALUES(rate_to_chf),
                         rate_to_cad   = VALUES(rate_to_cad),
                         rate_to_aud   = VALUES(rate_to_aud),
                         rate_to_sgd   = VALUES(rate_to_sgd);

DROP USER IF EXISTS 'appuser'@'localhost';
CREATE USER 'appuser'@'localhost' IDENTIFIED BY 'password';
GRANT SELECT, INSERT ON currencyconverter.* TO 'appuser'@'localhost';