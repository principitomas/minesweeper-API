package com.hiringtest.minesweeper.service.useraccount;

import com.hiringtest.minesweeper.domain.useraccount.UserAccount;

public interface UserAccountService {
    UserAccount getUserAccount(String email, String password);
    UserAccount add(UserAccount userAccount);
}
