/*
 * This file is generated by jOOQ.
 */
package org.jooq.codegen.minesweeper.tables;


import java.util.Arrays;
import java.util.List;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Identity;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Row9;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.TableOptions;
import org.jooq.UniqueKey;
import org.jooq.codegen.minesweeper.Keys;
import org.jooq.codegen.minesweeper.Minesweeper;
import org.jooq.codegen.minesweeper.tables.records.SquareRecord;
import org.jooq.impl.DSL;
import org.jooq.impl.TableImpl;
import org.jooq.types.UShort;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Square extends TableImpl<SquareRecord> {

    private static final long serialVersionUID = -55878596;

    /**
     * The reference instance of <code>minesweeper.square</code>
     */
    public static final Square SQUARE = new Square();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<SquareRecord> getRecordType() {
        return SquareRecord.class;
    }

    /**
     * The column <code>minesweeper.square.id</code>.
     */
    public final TableField<SquareRecord, UShort> ID = createField(DSL.name("id"), org.jooq.impl.SQLDataType.SMALLINTUNSIGNED.nullable(false).identity(true), this, "");

    /**
     * The column <code>minesweeper.square.game_id</code>.
     */
    public final TableField<SquareRecord, UShort> GAME_ID = createField(DSL.name("game_id"), org.jooq.impl.SQLDataType.SMALLINTUNSIGNED.nullable(false), this, "");

    /**
     * The column <code>minesweeper.square.revealed</code>.
     */
    public final TableField<SquareRecord, Byte> REVEALED = createField(DSL.name("revealed"), org.jooq.impl.SQLDataType.TINYINT, this, "");

    /**
     * The column <code>minesweeper.square.flag</code>.
     */
    public final TableField<SquareRecord, Byte> FLAG = createField(DSL.name("flag"), org.jooq.impl.SQLDataType.TINYINT, this, "");

    /**
     * The column <code>minesweeper.square.row_number</code>.
     */
    public final TableField<SquareRecord, Integer> ROW_NUMBER = createField(DSL.name("row_number"), org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>minesweeper.square.column_number</code>.
     */
    public final TableField<SquareRecord, Integer> COLUMN_NUMBER = createField(DSL.name("column_number"), org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>minesweeper.square.display_value</code>.
     */
    public final TableField<SquareRecord, String> DISPLAY_VALUE = createField(DSL.name("display_value"), org.jooq.impl.SQLDataType.VARCHAR(25), this, "");

    /**
     * The column <code>minesweeper.square.is_mine</code>.
     */
    public final TableField<SquareRecord, Byte> IS_MINE = createField(DSL.name("is_mine"), org.jooq.impl.SQLDataType.TINYINT, this, "");

    /**
     * The column <code>minesweeper.square.adjacent_mines</code>.
     */
    public final TableField<SquareRecord, Integer> ADJACENT_MINES = createField(DSL.name("adjacent_mines"), org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * Create a <code>minesweeper.square</code> table reference
     */
    public Square() {
        this(DSL.name("square"), null);
    }

    /**
     * Create an aliased <code>minesweeper.square</code> table reference
     */
    public Square(String alias) {
        this(DSL.name(alias), SQUARE);
    }

    /**
     * Create an aliased <code>minesweeper.square</code> table reference
     */
    public Square(Name alias) {
        this(alias, SQUARE);
    }

    private Square(Name alias, Table<SquareRecord> aliased) {
        this(alias, aliased, null);
    }

    private Square(Name alias, Table<SquareRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    public <O extends Record> Square(Table<O> child, ForeignKey<O, SquareRecord> key) {
        super(child, key, SQUARE);
    }

    @Override
    public Schema getSchema() {
        return Minesweeper.MINESWEEPER;
    }

    @Override
    public Identity<SquareRecord, UShort> getIdentity() {
        return Keys.IDENTITY_SQUARE;
    }

    @Override
    public UniqueKey<SquareRecord> getPrimaryKey() {
        return Keys.KEY_SQUARE_PRIMARY;
    }

    @Override
    public List<UniqueKey<SquareRecord>> getKeys() {
        return Arrays.<UniqueKey<SquareRecord>>asList(Keys.KEY_SQUARE_PRIMARY);
    }

    @Override
    public List<ForeignKey<SquareRecord, ?>> getReferences() {
        return Arrays.<ForeignKey<SquareRecord, ?>>asList(Keys.FK_GAME_GAME_ID);
    }

    public Game game() {
        return new Game(this, Keys.FK_GAME_GAME_ID);
    }

    @Override
    public Square as(String alias) {
        return new Square(DSL.name(alias), this);
    }

    @Override
    public Square as(Name alias) {
        return new Square(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Square rename(String name) {
        return new Square(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Square rename(Name name) {
        return new Square(name, null);
    }

    // -------------------------------------------------------------------------
    // Row9 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row9<UShort, UShort, Byte, Byte, Integer, Integer, String, Byte, Integer> fieldsRow() {
        return (Row9) super.fieldsRow();
    }
}
