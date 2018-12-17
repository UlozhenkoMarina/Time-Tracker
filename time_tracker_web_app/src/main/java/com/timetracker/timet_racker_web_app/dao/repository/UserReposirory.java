package com.timetracker.timet_racker_web_app.dao.repository;

import com.timetracker.timet_racker_web_app.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserReposirory extends CrudRepository<User, Long> {

    public User getUserByEmailAndPassword(String email, String password);
    public User getUserByEmail(String email);
    public User getUserByUsername(String username);
}
