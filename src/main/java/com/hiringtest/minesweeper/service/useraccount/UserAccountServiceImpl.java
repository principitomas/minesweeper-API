package com.hiringtest.minesweeper.service.useraccount;

import com.hiringtest.minesweeper.domain.useraccount.UserAccount;
import com.hiringtest.minesweeper.repository.useraccount.UserAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserAccountServiceImpl implements UserAccountService {

    @Autowired
    UserAccountRepository userAccountRepository;

    @Override
    public UserAccount getUserAccount(String email, String password) {
        UserAccount userAccount = userAccountRepository.findByEmail(email);
        return userAccount != null && userAccount.getPassword().equals(password) ?
                userAccount : null;
    }

    @Override
    public UserAccount add(UserAccount userAccount) {
        return userAccountRepository.add(userAccount);
    }
}
