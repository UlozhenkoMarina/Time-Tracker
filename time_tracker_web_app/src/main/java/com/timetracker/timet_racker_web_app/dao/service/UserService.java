package com.timetracker.timet_racker_web_app.dao.service;

import com.timetracker.timet_racker_web_app.dao.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import com.timetracker.timet_racker_web_app.model.User;
import org.springframework.stereotype.Service;


@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User addUser(User user) {
        try {
            user = userRepository.save(user);
            user = userRepository.getUserByEmailAndPassword(user.getEmail(), user.getPassword());
        } catch (Exception e) {
            return null;
        }
        return user;
    }

    public User getUser(String email, String password) {
        User user = userRepository.getUserByEmailAndPassword(email, password);
        return user;
    }

    public User getUser(String email) {
        User user = userRepository.getUserByEmail(email);
        return user;
    }

    public User getUserByUername(String username) {
        User user = userRepository.getUserByUsername(username);
        return user;
    }

    public User getUser(long id) {
        return userRepository.getUserById(id);
    }

    public User updateUser(User user) {
        if (user.getId() == 0) {
            user = userRepository.getUserByEmail(user.getEmail());
        }
        if (user != null) {
            userRepository.save(user);
            return userRepository.getUserById(user.getId());
        } else {
            return null;
        }
    }
}
