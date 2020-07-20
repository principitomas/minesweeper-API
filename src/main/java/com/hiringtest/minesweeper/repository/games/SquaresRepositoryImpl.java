package com.hiringtest.minesweeper.repository.games;

import com.hiringtest.minesweeper.domain.game.Square;
import com.hiringtest.minesweeper.repository.games.SquareRecordMapper;
import com.hiringtest.minesweeper.repository.games.SquaresRepository;
import org.jooq.DSLContext;
import org.jooq.InsertValuesStep7;
import org.jooq.InsertValuesStep8;
import org.jooq.codegen.minesweeper.tables.records.SquareRecord;
import org.jooq.types.UShort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.jooq.codegen.minesweeper.tables.Square.SQUARE;


@Service
public class SquaresRepositoryImpl implements SquaresRepository {


    @Autowired
    DSLContext dslContext;


    @Override
    public List<Square> findAllByGameId(Integer gameId) {
        return dslContext.select()
                .from(SQUARE)
                .where(SQUARE.GAME_ID.eq(UShort.valueOf(gameId)))
                .fetch()
                .map(new SquareRecordMapper());
    }

    @Override
    public Square update(Square square) {
        dslContext.update(SQUARE)
                .set(SQUARE.DISPLAY_VALUE, square.getDisplayValue())
                .set(SQUARE.FLAG, square.getFlag() ? Byte.valueOf("1") : Byte.valueOf("0"))
                .set(SQUARE.REVEALED, square.getRevealed() ? Byte.valueOf("1") : Byte.valueOf("0"))
                .where(SQUARE.GAME_ID.eq(UShort.valueOf(square.getGameId()))
                        .and(SQUARE.ROW_NUMBER.eq(square.getRow()))
                        .and(SQUARE.COLUMN_NUMBER.eq(square.getColumn())))
                .execute();
        return square;
    }

    @Override
    public List<Square> addAll(List<Square> squares) {
        InsertValuesStep8<SquareRecord, UShort, Integer, Integer, Byte, Byte, Byte, String, Integer> insertResultStep = dslContext
                .insertInto(SQUARE, SQUARE.GAME_ID, SQUARE.ROW_NUMBER, SQUARE.COLUMN_NUMBER, SQUARE.IS_MINE, SQUARE.FLAG, SQUARE.REVEALED, SQUARE.DISPLAY_VALUE,SQUARE.ADJACENT_MINES);

        squares.forEach(sqr ->
                insertResultStep.values(
                        UShort.valueOf(sqr.getGameId()),
                        sqr.getRow(),
                        sqr.getColumn(),
                        sqr.getIsMine() ? Byte.valueOf("1") : Byte.valueOf("0"),
                        sqr.getFlag() ? Byte.valueOf("1") : Byte.valueOf("0"),
                        sqr.getRevealed() ? Byte.valueOf("1") : Byte.valueOf("0"),
                        sqr.getDisplayValue(),
                        sqr.getAdjacentMines())
        );
        insertResultStep.execute();
        return squares;
    }
}
