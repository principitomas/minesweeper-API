package com.hiringtest.minesweeper.domain.game;


public class Settings {

    private Integer mines;
    private Integer rows;
    private Integer columns;

    public Settings(Integer mines, Integer rows, Integer columns) {
        this.mines = mines;
        this.rows = rows;
        this.columns = columns;
    }

    public Integer getMines() {
        return mines;
    }

    public void setMines(Integer mines) {
        this.mines = mines;
    }

    public Integer getRows() {
        return rows;
    }

    public void setRows(Integer rows) {
        this.rows = rows;
    }

    public Integer getColumns() {
        return columns;
    }

    public void setColumns(Integer columns) {
        this.columns = columns;
    }
}
