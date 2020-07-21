package com.hiringtest.minesweeper.repository.useraccount;

import com.hiringtest.minesweeper.domain.useraccount.UserAccount;

public interface UserAccountRepository {
    UserAccount findByEmail(String email);
    UserAccount add(UserAccount userAccount);
}
