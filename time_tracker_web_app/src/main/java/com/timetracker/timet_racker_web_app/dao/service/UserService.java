package com.timetracker.timet_racker_web_app.dao.service;

import com.timetracker.timet_racker_web_app.dao.repository.ContactRepository;
import com.timetracker.timet_racker_web_app.dao.repository.UserRepository;
import com.timetracker.timet_racker_web_app.model.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import com.timetracker.timet_racker_web_app.model.User;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ContactRepository contactRepository;

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
            return userRepository.findById(user.getId()).get();
        } else {
            return null;
        }
    }

    public List<Contact> getContacts(User user) {
        return contactRepository.getAllByUsersByUserOwner(user);
    }

    public void addContact(User userOwner, long idUserToAdd) {
        Contact contact = new Contact();
        contact.setUsersByUserOwner(userOwner);
        User user = userRepository.getUserById(idUserToAdd);
        contact.setUsersByContact(user);
        contactRepository.save(contact);
    }
}
