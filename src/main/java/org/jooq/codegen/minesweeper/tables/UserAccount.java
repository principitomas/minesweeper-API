/*
 * This file is generated by jOOQ.
 */
package org.jooq.codegen.minesweeper.tables;


import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Identity;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Row6;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.TableOptions;
import org.jooq.UniqueKey;
import org.jooq.codegen.minesweeper.Keys;
import org.jooq.codegen.minesweeper.Minesweeper;
import org.jooq.codegen.minesweeper.tables.records.UserAccountRecord;
import org.jooq.impl.DSL;
import org.jooq.impl.TableImpl;
import org.jooq.types.UShort;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class UserAccount extends TableImpl<UserAccountRecord> {

    private static final long serialVersionUID = -319325414;

    /**
     * The reference instance of <code>minesweeper.user_account</code>
     */
    public static final UserAccount USER_ACCOUNT = new UserAccount();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<UserAccountRecord> getRecordType() {
        return UserAccountRecord.class;
    }

    /**
     * The column <code>minesweeper.user_account.id</code>.
     */
    public final TableField<UserAccountRecord, UShort> ID = createField(DSL.name("id"), org.jooq.impl.SQLDataType.SMALLINTUNSIGNED.nullable(false).identity(true), this, "");

    /**
     * The column <code>minesweeper.user_account.email</code>.
     */
    public final TableField<UserAccountRecord, String> EMAIL = createField(DSL.name("email"), org.jooq.impl.SQLDataType.VARCHAR(50), this, "");

    /**
     * The column <code>minesweeper.user_account.password</code>.
     */
    public final TableField<UserAccountRecord, String> PASSWORD = createField(DSL.name("password"), org.jooq.impl.SQLDataType.VARCHAR(50), this, "");

    /**
     * The column <code>minesweeper.user_account.first_name</code>.
     */
    public final TableField<UserAccountRecord, String> FIRST_NAME = createField(DSL.name("first_name"), org.jooq.impl.SQLDataType.VARCHAR(50), this, "");

    /**
     * The column <code>minesweeper.user_account.last_name</code>.
     */
    public final TableField<UserAccountRecord, String> LAST_NAME = createField(DSL.name("last_name"), org.jooq.impl.SQLDataType.VARCHAR(50), this, "");

    /**
     * The column <code>minesweeper.user_account.date_of_birth</code>.
     */
    public final TableField<UserAccountRecord, LocalDateTime> DATE_OF_BIRTH = createField(DSL.name("date_of_birth"), org.jooq.impl.SQLDataType.LOCALDATETIME.nullable(false).defaultValue(org.jooq.impl.DSL.field("CURRENT_TIMESTAMP", org.jooq.impl.SQLDataType.LOCALDATETIME)), this, "");

    /**
     * Create a <code>minesweeper.user_account</code> table reference
     */
    public UserAccount() {
        this(DSL.name("user_account"), null);
    }

    /**
     * Create an aliased <code>minesweeper.user_account</code> table reference
     */
    public UserAccount(String alias) {
        this(DSL.name(alias), USER_ACCOUNT);
    }

    /**
     * Create an aliased <code>minesweeper.user_account</code> table reference
     */
    public UserAccount(Name alias) {
        this(alias, USER_ACCOUNT);
    }

    private UserAccount(Name alias, Table<UserAccountRecord> aliased) {
        this(alias, aliased, null);
    }

    private UserAccount(Name alias, Table<UserAccountRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    public <O extends Record> UserAccount(Table<O> child, ForeignKey<O, UserAccountRecord> key) {
        super(child, key, USER_ACCOUNT);
    }

    @Override
    public Schema getSchema() {
        return Minesweeper.MINESWEEPER;
    }

    @Override
    public Identity<UserAccountRecord, UShort> getIdentity() {
        return Keys.IDENTITY_USER_ACCOUNT;
    }

    @Override
    public UniqueKey<UserAccountRecord> getPrimaryKey() {
        return Keys.KEY_USER_ACCOUNT_PRIMARY;
    }

    @Override
    public List<UniqueKey<UserAccountRecord>> getKeys() {
        return Arrays.<UniqueKey<UserAccountRecord>>asList(Keys.KEY_USER_ACCOUNT_PRIMARY, Keys.KEY_USER_ACCOUNT_EMAIL);
    }

    @Override
    public UserAccount as(String alias) {
        return new UserAccount(DSL.name(alias), this);
    }

    @Override
    public UserAccount as(Name alias) {
        return new UserAccount(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public UserAccount rename(String name) {
        return new UserAccount(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public UserAccount rename(Name name) {
        return new UserAccount(name, null);
    }

    // -------------------------------------------------------------------------
    // Row6 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row6<UShort, String, String, String, String, LocalDateTime> fieldsRow() {
        return (Row6) super.fieldsRow();
    }
}
