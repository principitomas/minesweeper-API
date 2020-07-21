package com.hiringtest.minesweeper.service.authentication;

import com.hiringtest.minesweeper.domain.useraccount.UserAccount;
import com.hiringtest.minesweeper.repository.useraccount.UserAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;

@Component
public class AuthService {
    @Autowired
    UserAccountRepository userAccountRepository;

    public Authentication getAuthentication() {
        return SecurityContextHolder.getContext().getAuthentication();
    }

    public UserAccount getCurrentUser() {
        Authentication authentication = this.getAuthentication();
        User user = (User) authentication.getPrincipal();
        return userAccountRepository.findByEmail(user.getUsername());
    }
}
