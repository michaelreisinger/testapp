package com.bactwo.authserver.service;

import com.bactwo.authserver.dto.UserDTO;
import com.bactwo.authserver.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

    User save(UserDTO registrationDTO);
}
