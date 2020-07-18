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
