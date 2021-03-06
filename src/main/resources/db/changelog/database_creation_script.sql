--liquibase formatted sql

--changeset tprincipi:minesweeper-0 Create database tables

CREATE TABLE game (
    id SMALLINT UNSIGNED NOT NULL AUTO_INCREMENT,
    status VARCHAR(25),
    columns_number INTEGER,
    rows_number INTEGER,
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
    number_row INTEGER,
    number_column INTEGER,
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

--changeset tprincipi:minesweeper-2 Add user account for testing purposes
INSERT INTO user_account (email, password, first_name, last_name) VALUE ('test@email.com', '1234','test', 'test');
--changeset tprincipi:minesweeper-3 Added missing field for adjacent mines
ALTER TABLE square ADD COLUMN adjacent_mines INTEGER;


