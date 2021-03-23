package com.bactwo.authserver.service;

import com.bactwo.authserver.dto.UserDTO;
import com.bactwo.authserver.model.User;
import com.bactwo.authserver.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User save(UserDTO registrationDTO) {
        String userRole = "ROLE_USER";
        User user =
                new User(registrationDTO.getUserName(),
                        passwordEncoder.encode(registrationDTO.getPassword()),
                        registrationDTO.isActive(),
                        registrationDTO.getAuthorities().toString());
        return userRepository.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByUserName(userName);

        user.orElseThrow(() -> new UsernameNotFoundException("Not found: " + userName));

        return user.map(UserDTO::new).get();
    }

}