/*
 * This file is generated by jOOQ.
 */
package org.jooq.codegen.minesweeper.tables.records;


import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record9;
import org.jooq.Row9;
import org.jooq.codegen.minesweeper.tables.Square;
import org.jooq.impl.UpdatableRecordImpl;
import org.jooq.types.UShort;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class SquareRecord extends UpdatableRecordImpl<SquareRecord> implements Record9<UShort, UShort, Byte, Byte, Integer, Integer, String, Byte, Integer> {

    private static final long serialVersionUID = 1307987534;

    /**
     * Setter for <code>minesweeper.square.id</code>.
     */
    public void setId(UShort value) {
        set(0, value);
    }

    /**
     * Getter for <code>minesweeper.square.id</code>.
     */
    public UShort getId() {
        return (UShort) get(0);
    }

    /**
     * Setter for <code>minesweeper.square.game_id</code>.
     */
    public void setGameId(UShort value) {
        set(1, value);
    }

    /**
     * Getter for <code>minesweeper.square.game_id</code>.
     */
    public UShort getGameId() {
        return (UShort) get(1);
    }

    /**
     * Setter for <code>minesweeper.square.revealed</code>.
     */
    public void setRevealed(Byte value) {
        set(2, value);
    }

    /**
     * Getter for <code>minesweeper.square.revealed</code>.
     */
    public Byte getRevealed() {
        return (Byte) get(2);
    }

    /**
     * Setter for <code>minesweeper.square.flag</code>.
     */
    public void setFlag(Byte value) {
        set(3, value);
    }

    /**
     * Getter for <code>minesweeper.square.flag</code>.
     */
    public Byte getFlag() {
        return (Byte) get(3);
    }

    /**
     * Setter for <code>minesweeper.square.number_row</code>.
     */
    public void setNumberRow(Integer value) {
        set(4, value);
    }

    /**
     * Getter for <code>minesweeper.square.number_row</code>.
     */
    public Integer getNumberRow() {
        return (Integer) get(4);
    }

    /**
     * Setter for <code>minesweeper.square.number_column</code>.
     */
    public void setNumberColumn(Integer value) {
        set(5, value);
    }

    /**
     * Getter for <code>minesweeper.square.number_column</code>.
     */
    public Integer getNumberColumn() {
        return (Integer) get(5);
    }

    /**
     * Setter for <code>minesweeper.square.display_value</code>.
     */
    public void setDisplayValue(String value) {
        set(6, value);
    }

    /**
     * Getter for <code>minesweeper.square.display_value</code>.
     */
    public String getDisplayValue() {
        return (String) get(6);
    }

    /**
     * Setter for <code>minesweeper.square.is_mine</code>.
     */
    public void setIsMine(Byte value) {
        set(7, value);
    }

    /**
     * Getter for <code>minesweeper.square.is_mine</code>.
     */
    public Byte getIsMine() {
        return (Byte) get(7);
    }

    /**
     * Setter for <code>minesweeper.square.adjacent_mines</code>.
     */
    public void setAdjacentMines(Integer value) {
        set(8, value);
    }

    /**
     * Getter for <code>minesweeper.square.adjacent_mines</code>.
     */
    public Integer getAdjacentMines() {
        return (Integer) get(8);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<UShort> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record9 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row9<UShort, UShort, Byte, Byte, Integer, Integer, String, Byte, Integer> fieldsRow() {
        return (Row9) super.fieldsRow();
    }

    @Override
    public Row9<UShort, UShort, Byte, Byte, Integer, Integer, String, Byte, Integer> valuesRow() {
        return (Row9) super.valuesRow();
    }

    @Override
    public Field<UShort> field1() {
        return Square.SQUARE.ID;
    }

    @Override
    public Field<UShort> field2() {
        return Square.SQUARE.GAME_ID;
    }

    @Override
    public Field<Byte> field3() {
        return Square.SQUARE.REVEALED;
    }

    @Override
    public Field<Byte> field4() {
        return Square.SQUARE.FLAG;
    }

    @Override
    public Field<Integer> field5() {
        return Square.SQUARE.NUMBER_ROW;
    }

    @Override
    public Field<Integer> field6() {
        return Square.SQUARE.NUMBER_COLUMN;
    }

    @Override
    public Field<String> field7() {
        return Square.SQUARE.DISPLAY_VALUE;
    }

    @Override
    public Field<Byte> field8() {
        return Square.SQUARE.IS_MINE;
    }

    @Override
    public Field<Integer> field9() {
        return Square.SQUARE.ADJACENT_MINES;
    }

    @Override
    public UShort component1() {
        return getId();
    }

    @Override
    public UShort component2() {
        return getGameId();
    }

    @Override
    public Byte component3() {
        return getRevealed();
    }

    @Override
    public Byte component4() {
        return getFlag();
    }

    @Override
    public Integer component5() {
        return getNumberRow();
    }

    @Override
    public Integer component6() {
        return getNumberColumn();
    }

    @Override
    public String component7() {
        return getDisplayValue();
    }

    @Override
    public Byte component8() {
        return getIsMine();
    }

    @Override
    public Integer component9() {
        return getAdjacentMines();
    }

    @Override
    public UShort value1() {
        return getId();
    }

    @Override
    public UShort value2() {
        return getGameId();
    }

    @Override
    public Byte value3() {
        return getRevealed();
    }

    @Override
    public Byte value4() {
        return getFlag();
    }

    @Override
    public Integer value5() {
        return getNumberRow();
    }

    @Override
    public Integer value6() {
        return getNumberColumn();
    }

    @Override
    public String value7() {
        return getDisplayValue();
    }

    @Override
    public Byte value8() {
        return getIsMine();
    }

    @Override
    public Integer value9() {
        return getAdjacentMines();
    }

    @Override
    public SquareRecord value1(UShort value) {
        setId(value);
        return this;
    }

    @Override
    public SquareRecord value2(UShort value) {
        setGameId(value);
        return this;
    }

    @Override
    public SquareRecord value3(Byte value) {
        setRevealed(value);
        return this;
    }

    @Override
    public SquareRecord value4(Byte value) {
        setFlag(value);
        return this;
    }

    @Override
    public SquareRecord value5(Integer value) {
        setNumberRow(value);
        return this;
    }

    @Override
    public SquareRecord value6(Integer value) {
        setNumberColumn(value);
        return this;
    }

    @Override
    public SquareRecord value7(String value) {
        setDisplayValue(value);
        return this;
    }

    @Override
    public SquareRecord value8(Byte value) {
        setIsMine(value);
        return this;
    }

    @Override
    public SquareRecord value9(Integer value) {
        setAdjacentMines(value);
        return this;
    }

    @Override
    public SquareRecord values(UShort value1, UShort value2, Byte value3, Byte value4, Integer value5, Integer value6, String value7, Byte value8, Integer value9) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        value7(value7);
        value8(value8);
        value9(value9);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached SquareRecord
     */
    public SquareRecord() {
        super(Square.SQUARE);
    }

    /**
     * Create a detached, initialised SquareRecord
     */
    public SquareRecord(UShort id, UShort gameId, Byte revealed, Byte flag, Integer numberRow, Integer numberColumn, String displayValue, Byte isMine, Integer adjacentMines) {
        super(Square.SQUARE);

        set(0, id);
        set(1, gameId);
        set(2, revealed);
        set(3, flag);
        set(4, numberRow);
        set(5, numberColumn);
        set(6, displayValue);
        set(7, isMine);
        set(8, adjacentMines);
    }
}
