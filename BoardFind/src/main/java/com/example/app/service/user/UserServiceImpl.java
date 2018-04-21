package com.example.app.service.user;

import com.example.app.model.entity.User;
import com.example.app.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public boolean register(String username, String password, String email)
    {
        User user = new User();
        user.setusername(username);
        user.setPassword(password); //new BCryptPasswordEncoder().encode(password)
        user.setEmail(email);

        return this.userRepository.save(user).getId() != null;
    }
}
