package com.timetracker.timet_racker_web_app.dao.repository;

import com.timetracker.timet_racker_web_app.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {

    public User getUserByEmailAndPassword(String email, String password);
    public User getUserByEmail(String email);
    public User getUserByUsername(String username);
    public User getUserById(long id);
}
