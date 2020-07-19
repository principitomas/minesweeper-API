package com.hiringtest.minesweeper.service.games;

import com.hiringtest.minesweeper.domain.game.Action;
import com.hiringtest.minesweeper.domain.game.Settings;
import com.hiringtest.minesweeper.repository.games.GamesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.ws.rs.core.Response;


@Service
public class GamesService {

    @Autowired
    GamesRepository gamesRepository;



    public Response newGame(Settings settings) {
        return Response.ok().build();
    }

    public Response getGames() {
        return Response.ok().build();
    }

    public Response flagSquare() {
        return Response.ok().build();
    }

    public Response getGame(Integer id) {
        return  Response.ok().build();
    }

    public Response applyAction(Integer id,Action action) {
        return  Response.ok().build();
    }



}
