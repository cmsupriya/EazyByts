package com.chat_app_backend.service;

import com.chat_app_backend.repository.UserRepository;
import org.springframework.security.core.userdetails.*;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username)
            .map(u -> {
                UserBuilder builder = User.withUsername(u.getUsername())
                    .password(u.getPassword())
                    .authorities(u.getRoles().split(","));
                return builder.build();
            })
            .orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }
}