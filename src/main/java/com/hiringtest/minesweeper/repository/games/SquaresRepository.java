package com.hiringtest.minesweeper.repository.games;

import com.hiringtest.minesweeper.domain.game.Square;

import java.util.List;

public interface SquaresRepository {
    List<Square> findAllByGameId(Integer gameId);
    Square update(Square square);
    List<Square>  addAll(List<Square> square);
}
