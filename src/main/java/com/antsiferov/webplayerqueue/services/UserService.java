package com.antsiferov.webplayerqueue.services;

import com.antsiferov.webplayerqueue.entity.CustomUser;
import com.antsiferov.webplayerqueue.entity.User;
import com.antsiferov.webplayerqueue.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService implements UserDetailsService {

    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByName(username)
                .map(user -> new CustomUser(user))
                .orElse(null);
    }

    public User findUserByName(String username) {
        return userRepository.findUserByName(username);
    }

    public void save(User user) {
        userRepository.save(user);
    }
}