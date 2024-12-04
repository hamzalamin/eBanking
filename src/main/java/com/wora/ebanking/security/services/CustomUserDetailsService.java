package com.wora.ebanking.security.services;

import com.wora.ebanking.exceptions.EntityNotFoundException;
import com.wora.ebanking.models.entities.User;
import com.wora.ebanking.repositoies.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {
    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByName(username)
                .orElseThrow(() -> new EntityNotFoundException("User", username));
        return User.builder()
                .name(user.getUsername())
                .password(user.getPassword())
                .role(user.getRole())
                .build();
    }
}
