package com.hiringtest.minesweeper.repository.useraccount;

import com.hiringtest.minesweeper.domain.useraccount.UserAccount;
import org.jooq.Record;
import org.jooq.RecordMapper;

import static org.jooq.codegen.minesweeper.tables.UserAccount.USER_ACCOUNT;

public class UserAccountRecordMapper implements RecordMapper <Record, UserAccount> {
    @Override
    public UserAccount map(Record record) {
        return new UserAccount(
                record.get(USER_ACCOUNT.ID).intValue(),
                record.get(USER_ACCOUNT.EMAIL),
                record.get(USER_ACCOUNT.FIRST_NAME),
                record.get(USER_ACCOUNT.LAST_NAME),
                record.get(USER_ACCOUNT.PASSWORD)
        );
    }
}
