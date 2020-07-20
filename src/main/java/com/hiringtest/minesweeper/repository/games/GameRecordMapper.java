package com.hiringtest.minesweeper.repository.games;

import com.hiringtest.minesweeper.domain.game.Game;
import com.hiringtest.minesweeper.domain.game.Settings;
import com.hiringtest.minesweeper.domain.game.Status;
import org.jooq.Record;
import org.jooq.RecordMapper;

import static org.jooq.codegen.minesweeper.tables.Game.GAME;

public class GameRecordMapper implements RecordMapper<Record, Game> {

    @Override
    public Game map(Record record) {
        Settings settings = new Settings(record.get(GAME.MINES), record.get(GAME.ROWS), record.get(GAME.COLUMNS));
        Game game = new Game(
                record.get(GAME.ID).intValue(),
                Status.valueOf(record.get(GAME.STATUS)),
                settings,
                null,
                record.get(GAME.USER_ACCOUNT_ID).intValue()
        );


        return null;
    }
}
