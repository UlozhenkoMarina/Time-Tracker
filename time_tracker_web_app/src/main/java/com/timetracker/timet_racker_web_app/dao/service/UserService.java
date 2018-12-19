package com.timetracker.timet_racker_web_app.dao.service;

import com.timetracker.timet_racker_web_app.dao.repository.ContactRepository;
import com.timetracker.timet_racker_web_app.dao.repository.UserRepository;
import com.timetracker.timet_racker_web_app.model.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import com.timetracker.timet_racker_web_app.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
        try {
            User user = userRepository.getUserByEmailAndPassword(email, password);
            return user;
        } catch (Exception ex) {
            return null;
        }
    }

    public User getUser(String email) {
        try {
            User user = userRepository.getUserByEmail(email);
            return user;
        } catch (Exception ex) {
            return null;
        }
    }

    public User getUserByUername(String username) {
        try {
            User user = userRepository.getUserByUsername(username);
            return user;
        } catch (Exception ex) {
            return null;
        }
    }

    public User getUser(int id) {
        try {
            return userRepository.findById(id).get();
        } catch (Exception ex) {
            return null;
        }
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
        try {
            return contactRepository.getAllByUsersByUserOwner(user);
        } catch (Exception ex) {
            return null;
        }
    }

    public List<User> getContactsUser(User user) {
        try {
            List<Contact> contacts = getContacts(user);
            List<User> users = new ArrayList<>();
            for (Contact contact : contacts) {
                users.add(contact.getUsersByContact());
            }
            return users;
        } catch (Exception ex) {
            return null;
        }
    }

    public void addContact(User userOwner, int idUserToAdd) {
        try {
            Contact contact = new Contact();
            contact.setUsersByUserOwner(userOwner);
            User user = userRepository.findById(idUserToAdd).get();
            contact.setUsersByContact(user);
            contactRepository.save(contact);
        } catch (Exception ex) {
        }
    }
}
