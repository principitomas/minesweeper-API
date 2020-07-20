package com.hiringtest.minesweeper.repository.games;

import com.hiringtest.minesweeper.domain.game.Square;
import org.jooq.Record;
import org.jooq.RecordMapper;

import static org.jooq.codegen.minesweeper.tables.Square.SQUARE;

public class SquareRecordMapper implements RecordMapper<Record, Square> {
    @Override
    public Square map(Record record) {
        return new Square(
                record.get(SQUARE.REVEALED).intValue() == 1,
                record.get(SQUARE.FLAG).intValue() == 1,
                record.get(SQUARE.ROW_NUMBER),
                record.get(SQUARE.COLUMN_NUMBER),
                record.get(SQUARE.DISPLAY_VALUE),
                record.get(SQUARE.IS_MINE).intValue() == 1,
                record.get(SQUARE.GAME_ID).intValue(),
                record.get(SQUARE.ADJACENT_MINES).intValue()
        );
    }
}
