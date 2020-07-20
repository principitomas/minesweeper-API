package com.hiringtest.minesweeper.service.games;

import com.google.common.collect.Lists;
import com.hiringtest.minesweeper.domain.game.*;
import com.hiringtest.minesweeper.repository.games.GamesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.ws.rs.core.Response;
import java.util.List;
import java.util.Random;


@Service
public class GamesServiceImpl implements GamesService {

    @Autowired
    GamesRepository gamesRepository;

    @Autowired
    SquaresService squaresService;

    public Response newGame(Settings settings, Integer userAccountId) {
        Random random = new Random();
        List<Square> squares = Lists.newArrayList();

        //Mine random positions
        boolean [][] minesPositions = new boolean[settings.getRows()][settings.getColumns()];
        for (int i = 0; i < settings.getMines(); i++) {
            int column = random.nextInt(settings.getColumns());
            int row = random.nextInt(settings.getRows());
            minesPositions[row][column] = true;
        }

        //set mines in squares creation
        for (int j = 0; j < settings.getRows(); j++) {
            for (int k = 0; k < settings.getColumns(); k++) {
                squares.add(new Square(false, false, j, k, "", minesPositions[j][k]));
            }
        }

        List<Square> squaresWithAdjMines = squaresService.setAdjacentMines(squares, settings.getRows(), settings.getColumns());

        Game newGame = new Game(null, Status.IN_PROGRESS, settings, squaresWithAdjMines, userAccountId);

        Game storedGame = gamesRepository.add(newGame);

        return Response.status(Response.Status.CREATED)
                .entity(storedGame)
                .build();
    }

    public Response revealSquare(Integer gameId, Integer column, Integer row, Integer accountUser) {
        Game game = gamesRepository.findById(gameId, accountUser);

        if (column > game.getSettings().getColumns() - 1 || column > game.getSettings().getRows() - 1) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }

        Square squareToReveal = game.getSquares().stream()
                .filter(sqr -> sqr.getColumn().equals(column) && sqr.getRow().equals(row)).findFirst().get();
        Game updatedGame = null;

        if (squareToReveal.getIsMine()) {
            game.getSquares().forEach(square -> {
                if (square.getIsMine()) {
                    square.setRevealed(true);
                    square.setDisplayValue("*");
                }
            });
            game.setStatus(Status.FINISHED);
            updatedGame = gamesRepository.update(game);
        } else {
            squaresService.reveal(gameId, column, row);
            gamesRepository.findById(gameId,accountUser);
            updatedGame = gamesRepository.findById(gameId,accountUser);
        }

        return Response.status(201).entity(updatedGame).build();
    }

    public Response getGames(Integer userId) {
        List<Game> games = gamesRepository.findAll(userId);
        return Response.ok()
                .entity(games)
                .build();
    }

    public Response addFlag(Integer gameId, Integer column, Integer row, FlagType type, Integer accountUserId) {
        Game game = gamesRepository.findById(gameId, accountUserId);

        if (column > game.getSettings().getColumns() - 1 || column > game.getSettings().getRows() - 1) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }

        game.getSquares()
                .stream()
                .filter(square -> square.getColumn().equals(column) && square.getRow().equals(row))
                .findFirst().ifPresent(sqr -> {
            sqr.setFlag(true);
            sqr.setDisplayValue(type.equals(FlagType.RED_FLAG) ? "F" : "?");
        });

        Game updatedGme = gamesRepository.update(game);
        return Response.ok().entity(updatedGme).build();
    }

    public Response getGame(Integer id, Integer useAccountId) {
        Game game = gamesRepository.findById(id, useAccountId);
        return  Response.ok().entity(game).build();
    }

    public Response applyAction(Integer id, Action action, Integer accountUserId) {
        Game game = gamesRepository.findById(id, accountUserId);
        if (Action.PAUSE.equals(action)) {
            game.setStatus(Status.PAUSED);
        }

        if (Action.RESUME.equals(action)) {
            game.setStatus(Status.IN_PROGRESS);
        }

        Game updatedGame = gamesRepository.update(game);
        return  Response.ok().entity(updatedGame).build();
    }
}
