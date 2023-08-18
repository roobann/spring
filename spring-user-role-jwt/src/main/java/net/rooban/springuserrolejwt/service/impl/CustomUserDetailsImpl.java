package net.rooban.springuserrolejwt.service.impl;

import net.rooban.springuserrolejwt.entity.User;
import net.rooban.springuserrolejwt.repository.UserRepository;
import net.rooban.springuserrolejwt.service.CustomUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.getUserByUsername(username);
        if (user == null) {
            throw  new UsernameNotFoundException("User not found");
        }
        return new CustomUserDetails(user);
    }
}
