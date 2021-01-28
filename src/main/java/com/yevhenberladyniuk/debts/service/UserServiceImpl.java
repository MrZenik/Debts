package com.yevhenberladyniuk.debts.service;

import com.yevhenberladyniuk.debts.domain.User;
import com.yevhenberladyniuk.debts.dto.CreateUserForm;
import com.yevhenberladyniuk.debts.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService, UserDetailsService {

    private UserRepository userRepository;

    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void create(CreateUserForm createUserForm) {
        User user = User.builder()
                .username(createUserForm.getUsername())
                .password(passwordEncoder.encode(createUserForm.getPassword()))
                .firstName(createUserForm.getFirstName())
                .lastName(createUserForm.getLastName())
                .active(true)
                .build();

        userRepository.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        return userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found!"));
    }
}
