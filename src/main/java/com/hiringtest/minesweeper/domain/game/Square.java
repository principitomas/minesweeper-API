package com.hiringtest.minesweeper.domain.game;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Square {

    private Boolean revealed;
    private Boolean flag;
    private Integer row;
    private Integer column;
    private String displayValue;
    @JsonIgnore
    private Boolean isMine;
    @JsonIgnore
    private Integer gameId;
    @JsonIgnore
    private Integer adjacentMines;

    public Square() {
    }

    public Square(Boolean revealed, Boolean flag, Integer row, Integer column, String displayValue) {
        this.revealed = revealed;
        this.flag = flag;
        this.row = row;
        this.column = column;
        this.displayValue = displayValue;
    }

    public Square(Boolean revealed, Boolean flag, Integer row, Integer column, String displayValue, Boolean isMine) {
        this.revealed = revealed;
        this.flag = flag;
        this.row = row;
        this.column = column;
        this.displayValue = displayValue;
        this.isMine = isMine;
        this.adjacentMines = 0;
    }

    public Square(Boolean revealed, Boolean flag, Integer row, Integer column, String displayValue, Boolean isMine, Integer gameId, Integer adjacentMines) {
        this.revealed = revealed;
        this.flag = flag;
        this.row = row;
        this.column = column;
        this.displayValue = displayValue;
        this.isMine = isMine;
        this.gameId = gameId;
        this.adjacentMines = adjacentMines;
    }

    public Integer getRow() {
        return row;
    }

    public void setRow(Integer row) {
        this.row = row;
    }

    public Integer getColumn() {
        return column;
    }

    public void setColumn(Integer column) {
        this.column = column;
    }

    public Boolean getRevealed() {
        return revealed;
    }

    public void setRevealed(Boolean revealed) {
        this.revealed = revealed;
    }

    public Boolean getFlag() {
        return flag;
    }

    public void setFlag(Boolean flag) {
        this.flag = flag;
    }

    public String getDisplayValue() {
        return displayValue;
    }

    public void setDisplayValue(String displayValue) {
        this.displayValue = displayValue;
    }

    public Boolean getIsMine() {
        return isMine;
    }

    public void setIsMine(Boolean isMine) {
        this.isMine = isMine;
    }

    public Integer getGameId() {
        return gameId;
    }

    public void setGameId(Integer gameId) {
        this.gameId = gameId;
    }

    public Integer getAdjacentMines() {
        return adjacentMines;
    }

    public void setAdjacentMines(Integer adjacentMines) {
        this.adjacentMines = adjacentMines;
    }
}
