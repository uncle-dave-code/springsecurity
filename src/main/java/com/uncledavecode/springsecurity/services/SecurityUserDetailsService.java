package com.uncledavecode.springsecurity.services;

import com.uncledavecode.springsecurity.repositories.UserRepository;
import com.uncledavecode.springsecurity.security.SecurityUser;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class SecurityUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    public SecurityUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        var user = this.userRepository.findByUsername(username);

        if(user.isPresent()){
           return new SecurityUser(user.get());
        }

        throw new UsernameNotFoundException("User not found: " + username);
    }
}
