drop table if exists stats;

create table if not exists stats
(
    id        INTEGER generated always as identity
        constraint stats_pk PRIMARY KEY,
    app       varchar   NOT NULL,
    uri       varchar   NOT NULL,
    ip        varchar   NOT NULL,
    timestamp timestamp NOT NULL
);