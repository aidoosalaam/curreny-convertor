package com.charmedteeth.currencyrate.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class JwtUserDetailsService implements UserDetailsService {

    @Value("${client.id.value}")
    String clientId;

    @Value("${client.key.value}")
    String clientPassword;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if(clientId.equals(username)){
            return new User(clientId,clientPassword,new ArrayList<>());
        }else {
            throw new UsernameNotFoundException("User not found with username : "+ username);
        }
    }
}
