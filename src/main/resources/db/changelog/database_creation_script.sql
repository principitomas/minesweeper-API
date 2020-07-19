--liquibase formatted sql

--changeset tprincipi:minesweeper-0 Create database tables

CREATE TABLE game (
    id SMALLINT UNSIGNED NOT NULL AUTO_INCREMENT,
    status VARCHAR(25),
    columns INTEGER,
    rows INTEGER,
    mines INTEGER,
    user_id INTEGER,
    duration INTEGER,
    CONSTRAINT pk_game_id PRIMARY KEY (id)
);

CREATE TABLE square (
    id SMALLINT UNSIGNED NOT NULL AUTO_INCREMENT,
    game_id SMALLINT UNSIGNED NOT NULL,
    revealed BOOLEAN,
    flag BOOLEAN,
    row_number INTEGER,
    column_number INTEGER,
    display_value VARCHAR(25),
    CONSTRAINT pk_square_id PRIMARY KEY (id)
);
alter table square add constraint fk_game_game_id foreign key (game_id) references game (id);

--changeset tprincipi:minesweeper-1 Add new field to square table
ALTER TABLE square ADD COLUMN is_mine BOOLEAN;

CREATE TABLE user_account (
    id SMALLINT UNSIGNED NOT NULL AUTO_INCREMENT,
    email VARCHAR(50) UNIQUE,
    password VARCHAR(50),
    first_name  VARCHAR(50),
    last_name  VARCHAR(50),
    date_of_birth TIMESTAMP,
    CONSTRAINT pk_game_id PRIMARY KEY (id)
);

ALTER TABLE game ADD COLUMN user_account_id SMALLINT UNSIGNED NOT NULL;
ALTER TABLE game ADD CONSTRAINT fk_user_account_id foreign key (user_account_id) references user_account (id);
