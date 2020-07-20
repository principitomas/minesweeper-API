package com.hiringtest.minesweeper.repository.games;

import com.hiringtest.minesweeper.domain.game.Game;
import com.hiringtest.minesweeper.domain.game.Settings;
import com.hiringtest.minesweeper.domain.game.Square;
import com.hiringtest.minesweeper.domain.game.Status;
import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.Result;
import org.jooq.types.UShort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static org.jooq.codegen.minesweeper.tables.Game.GAME;
import static org.jooq.codegen.minesweeper.tables.Square.SQUARE;

@Service
public class GamesRepositoryImpl implements GamesRepository {

    @Autowired
    private DSLContext dslContext;

    @Autowired
    private SquaresRepository squaresRepository;

    @Override
    public List<Game> findAll(Integer userAccountId) {
        Result<Record> records = dslContext.select()
                .from(GAME)
                .where(GAME.USER_ACCOUNT_ID.eq(UShort.valueOf(userAccountId)))
                .fetch();

        if (records != null) {
            List<Game> games = records.map(new GameRecordMapper());
            List<Integer> ids = games.stream().map(game -> game.getId()).collect(Collectors.toList());
            Result<Record> squaresRecords = dslContext.select()
                    .from(SQUARE)
                    .where(SQUARE.GAME_ID.in(ids))
                    .fetch();

            SquareRecordMapper squareRecordMapper = new SquareRecordMapper();
            games.forEach(game -> {

                List<Square> gameSquareRecords =  squaresRecords.stream()
                        .filter(
                                squareRecord -> squareRecord.get(SQUARE.GAME_ID).intValue() == game.getId().intValue())
                        .map(record -> squareRecordMapper.map(record))
                        .collect(Collectors.toList());
                game.setSquares(gameSquareRecords);

            });
            return games;
        }

        return null;
    }

    @Override
    public Game findById(Integer id, Integer userAccountId) {
        Record record = dslContext.select()
                .from(GAME)
                .where(GAME.ID.eq(UShort.valueOf(id)))
                .and(GAME.USER_ACCOUNT_ID.eq(UShort.valueOf(userAccountId)))
                .fetchOne();

        if (record != null) {
            List<Square> squares = squaresRepository.findAllByGameId(record.get(GAME.ID).intValue());
            Settings settings = new Settings(record.get(GAME.MINES), record.get(GAME.ROWS), record.get(GAME.COLUMNS));
            Game game = new Game(
                    record.get(GAME.ID).intValue(),
                    Status.valueOf(record.get(GAME.STATUS)),
                    settings,
                    squares,
                    record.get(GAME.USER_ACCOUNT_ID).intValue()
            );
            return game;
        }

        return null;
    }

    @Override
    public Game add(Game game) {
        int gameId = dslContext.insertInto(GAME, GAME.STATUS, GAME.COLUMNS, GAME.ROWS, GAME.MINES, GAME.USER_ACCOUNT_ID)
                .values(
                        game.getStatus().toString(),
                        game.getSettings().getColumns(),
                        game.getSettings().getRows(),
                        game.getSettings().getMines(),
                        UShort.valueOf(game.getUserAccountId())
                )
                .returning(GAME.ID)
                .fetchOne()
                .map(record -> record.getValue(GAME.ID).intValue());
        game.setId(gameId);
        game.getSquares().forEach(square -> square.setGameId(gameId));
        squaresRepository.addAll(game.getSquares());
        return game;
    }

    @Override
    public Game update(Game game) {
        dslContext.update(GAME)
                .set(GAME.STATUS, game.getStatus().toString())
                .set(GAME.COLUMNS, game.getSettings().getColumns())
                .set(GAME.ROWS, game.getSettings().getRows())
                .set(GAME.MINES, game.getSettings().getMines())
                .set(GAME.USER_ACCOUNT_ID, UShort.valueOf(game.getUserAccountId()))
                .execute();
        game.getSquares().forEach(square -> squaresRepository.update(square));
        return game;
    }
}
