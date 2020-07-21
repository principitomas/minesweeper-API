package com.hiringtest.minesweeper;

import com.google.common.collect.Lists;
import com.hiringtest.minesweeper.domain.useraccount.UserAccount;
import com.hiringtest.minesweeper.repository.useraccount.UserAccountRepository;
import com.hiringtest.minesweeper.service.useraccount.UserAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
public class AuthProvider implements AuthenticationProvider {

    @Autowired
    UserAccountRepository userAccountRepository;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        UsernamePasswordAuthenticationToken authenticationToken = null;
        String username = authentication.getName();
        String password = authentication.getCredentials().toString();
        UserAccount user = userAccountRepository.findByEmail(username);
        if(user != null){
            if (username.equals(user.getEmail()) && password.equals(user.getPassword())) {
                Collection<GrantedAuthority> grantedAuthorities = Lists.newArrayList();
                grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_USER"));
                authenticationToken = new UsernamePasswordAuthenticationToken(
                        new User(username, password, grantedAuthorities), password, grantedAuthorities);
            }
        } else {
            throw new UsernameNotFoundException("Could not find user");
        }

        return authenticationToken;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }


}