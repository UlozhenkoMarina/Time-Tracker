package com.timetracker.timet_racker_web_app.dao.repository;

import com.timetracker.timet_racker_web_app.model.Category;
import com.timetracker.timet_racker_web_app.model.Event;
import com.timetracker.timet_racker_web_app.model.User;
import org.springframework.data.repository.CrudRepository;

import java.sql.Timestamp;
import java.util.List;

public interface EventRepository extends CrudRepository<Event, Long> {

    public List<Event> getAllByDateAndUsersByUserAndCategoriesByCategory(Timestamp date, User user, Category category);
    public List<Event> getAllByUsersByUserAndCategoriesByCategory(User user, Category category);
    public List<Event> getAllByUsersByUserAndDate(User user, Timestamp date);
    public List<Event> getAllByUsersByUser(User user);
    public Event getById(long id);
}
