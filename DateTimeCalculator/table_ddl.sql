drop database if exists dtcalculator;
create database dtcalculator;
\c dtcalculator;

CREATE TABLE operation_transaction
(
    id        serial       NOT NULL PRIMARY KEY,
    inputs    text         NOT NULL,
    operation varchar(255) NOT NULL,
    output    text         NOT NULL
);

CREATE TABLE date_time_operation
(
    id                       serial       NOT NULL PRIMARY KEY,
    time_stamp               varchar(255) NOT NULL,
    operation_transaction_id int          NOT NULL REFERENCES operation_transaction (id)
);