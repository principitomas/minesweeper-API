package com.hiringtest.minesweeper.repository.games;

import com.hiringtest.minesweeper.domain.game.Game;

import java.util.List;

public interface GamesRepository {


    List<Game> findAll(Integer userAccountId);
    Game findById(Integer id, Integer userAccountId);
    Game add(Game game);
    Game update(Game game);
}
