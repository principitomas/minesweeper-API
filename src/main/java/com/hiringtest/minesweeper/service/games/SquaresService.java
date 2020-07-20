package com.hiringtest.minesweeper.service.games;

import com.hiringtest.minesweeper.domain.game.Square;

import java.util.List;

public interface SquaresService {
    void reveal(Integer gameId, Integer column, Integer row);
    List<Square> setAdjacentMines(List<Square> squares, Integer rows,  Integer columns);
}
