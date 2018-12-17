package com.timetracker.timet_racker_web_app.dao.repository;

import com.timetracker.timet_racker_web_app.model.Contact;
import com.timetracker.timet_racker_web_app.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ContactRepository extends CrudRepository<Contact, Long> {
    public List<Contact> getAllByUsersByUserOwner(User user);
    public List<Contact> getAllByUsersByUserOwnerAndBlocked(User user, byte blocked);
}
