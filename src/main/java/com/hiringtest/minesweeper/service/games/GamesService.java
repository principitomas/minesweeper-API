package com.hiringtest.minesweeper.service.games;

import com.hiringtest.minesweeper.domain.game.Action;
import com.hiringtest.minesweeper.domain.game.Settings;

import javax.ws.rs.core.Response;

public interface GamesService {
    Response revealSquare(Integer gameId, Integer column, Integer row, Integer accountUserId);

    Response newGame(Settings settings, Integer userAccountId);

    Response getGames(Integer useAccountId);

    Response flagSquare(Integer gameId, Integer column, Integer row, Integer accountUserId);

    Response getGame(Integer id, Integer userAccountId);

    Response applyAction(Integer id, Action action, Integer accountUserId);
}
