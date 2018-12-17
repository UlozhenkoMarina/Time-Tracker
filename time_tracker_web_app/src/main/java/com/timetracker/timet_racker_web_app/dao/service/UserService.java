package com.timetracker.timet_racker_web_app.dao.service;

import com.timetracker.timet_racker_web_app.dao.repository.UserReposirory;
import org.springframework.beans.factory.annotation.Autowired;
import com.timetracker.timet_racker_web_app.model.User;
import org.springframework.stereotype.Service;


@Service
public class UserService {

    @Autowired
    private UserReposirory userReposirory;

    public User addUser(User user) {
        try {
            user = userReposirory.save(user);
            user = userReposirory.getUserByEmailAndPassword(user.getEmail(), user.getPassword());
        } catch (Exception e) {
            return null;
        }
        return user;
    }

    public User getUser(String email, String password) {
        User user = userReposirory.getUserByEmailAndPassword(email, password);
        return user;
    }

    public User getUser(String email) {
        User user = userReposirory.getUserByEmail(email);
        return user;
    }

    public User getUserByUername(String username) {
        User user = userReposirory.getUserByUsername(username);
        return user;
    }
}
