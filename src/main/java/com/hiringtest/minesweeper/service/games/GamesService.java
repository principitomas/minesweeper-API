package com.hiringtest.minesweeper.service.games;

import com.hiringtest.minesweeper.domain.game.Action;
import com.hiringtest.minesweeper.domain.game.FlagType;
import com.hiringtest.minesweeper.domain.game.Settings;

import javax.ws.rs.core.Response;

public interface GamesService {
    Response revealSquare(Integer gameId, Integer column, Integer row, Integer accountUserId);

    Response newGame(Settings settings, Integer userAccountId);

    Response getGames(Integer useAccountId);

    Response addFlag(Integer gameId, Integer column, Integer row, FlagType type, Integer accountUserId);

    Response getGame(Integer id, Integer userAccountId);

    Response applyAction(Integer id, Action action, Integer accountUserId);
}
