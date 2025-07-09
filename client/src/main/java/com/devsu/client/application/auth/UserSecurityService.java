package com.devsu.client.application.auth;

import com.devsu.client.infrastructure.persistence.entity.ClientEntity;
import com.devsu.client.infrastructure.persistence.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class UserSecurityService implements UserDetailsService {

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        ClientEntity client = clientRepository.findByPersonIdentification(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found: " + username));

        String[] roles = {"ADMIN"};

        return User.builder()
                .username(username)
                .password(client.getPassword())
                .authorities(this.grantedAuthorities(roles))
                .accountLocked(!client.getState())
                .disabled(!client.getState())
                .build();
    }

    private List<GrantedAuthority> grantedAuthorities(String[] roles) {
        List<GrantedAuthority> authorities = new ArrayList<>();
        for (String role : roles) {
            authorities.add(new SimpleGrantedAuthority("ROLE_" + role));
        }
        return authorities;
    }
}
