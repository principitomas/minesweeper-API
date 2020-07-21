package com.hiringtest.minesweeper.repository.useraccount;

import com.hiringtest.minesweeper.domain.useraccount.UserAccount;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static org.jooq.codegen.minesweeper.tables.Game.GAME;
import static org.jooq.codegen.minesweeper.tables.UserAccount.USER_ACCOUNT;

@Service
public class UserAccountRepositoryImpl implements UserAccountRepository {

    @Autowired
    DSLContext dslContext;

    @Override
    public UserAccount findByEmail(String email) {
        UserAccount userAccount = dslContext.select()
                .from(USER_ACCOUNT)
                .where(USER_ACCOUNT.EMAIL.eq(email))
                .fetchOne().map(new UserAccountRecordMapper());
        return userAccount;
    }

    @Override
    public UserAccount add(UserAccount userAccount) {
        int userAccountId = dslContext.insertInto(USER_ACCOUNT,
                USER_ACCOUNT.EMAIL,
                USER_ACCOUNT.FIRST_NAME,
                USER_ACCOUNT.LAST_NAME,
                USER_ACCOUNT.PASSWORD)
                .values(userAccount.getEmail(),
                        userAccount.getFirstName(),
                        userAccount.getLastName(),
                        userAccount.getPassword()
                ).returning(USER_ACCOUNT.ID)
                .fetchOne()
                .map(record -> record.getValue(GAME.ID).intValue());
        userAccount.setId(userAccountId);
        return userAccount;
    }
}
