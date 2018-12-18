package com.timetracker.timet_racker_web_app.dao.service;

import com.timetracker.timet_racker_web_app.dao.repository.*;
import com.timetracker.timet_racker_web_app.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;


@Service
public class EventService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    public EventNoteRepository eventNoteRepository;

    @Autowired
    public DateNoteRepository dateNoteRepository;

    public void addCategory(Category category) {
        categoryRepository.save(category);
    }

    public List<Category> getSystemCategories() {
        try {
            return categoryRepository.getAllBySystem((byte) 1);
        } catch (Exception ex) {
            return null;
        }
    }

    public List<Category> getUserCategories(int id) {
        try {
            User user = userRepository.findById(id).get();
            return (List<Category>) user.getCategoriesById();
        } catch (Exception ex) {
            return null;
        }
    }

    public List<Event> getEventsByCategoryAndDate(User user, Category category, Timestamp date) {
        try {
            return eventRepository.getAllByDateAndUsersByUserAndCategoriesByCategory(date, user, category);
        } catch (Exception ex) {
            return null;
        }
    }

    public List<Event> getEventsByCategory(User user, Category category) {
        try {
            return eventRepository.getAllByUsersByUserAndCategoriesByCategory(user, category);
        } catch (Exception ex) {
            return null;
        }
    }

    public List<Event> getEventsByDate(User user, Timestamp date) {
        try {
            return eventRepository.getAllByUsersByUserAndDate(user, date);
        } catch (Exception ex) {
            return null;
        }
    }

    public List<Event> getEvents(User user) {
        try {
            user = userRepository.findById(user.getId()).get();
            return eventRepository.getAllByUsersByUser(user);
        } catch (Exception ex) {
            return null;
        }
    }

    public void updateEvent(Event event) {
        eventRepository.save(event);
    }

    public void addEvent(User user, Event event, Category category) {
        event.setUsersByUser(user);
        if(category != null) {
            event.setCategoriesByCategory(category);
        }
        eventRepository.save(event);
    }

    public void addEventNote(Event event, EventNote note) {
        note.setEventsByEvent(event);
        eventNoteRepository.save(note);
    }

    public void updateEventNote(EventNote note) {
        eventNoteRepository.save(note);
    }

    public List<EventNote> getEventNotes(Event event) {
        return eventNoteRepository.getAllByEventsByEvent(event);
    }

    public void addDateNote(User user, DateNote note) {
        note.setUsersByUser(user);
        dateNoteRepository.save(note);
    }

    public void updateDateNote(DateNote note) {
        dateNoteRepository.save(note);
    }

    public List<DateNote> getDateNotes(User user) {
        try {
            return dateNoteRepository.getAllByUsersByUser(user);
        } catch (Exception ex) {
            return null;
        }
    }

    public List<DateNote> getDateNotes(User user, Timestamp date) {
        try {
            List<DateNote> list = dateNoteRepository.getAllByUsersByUserAndDate(user, date);
            return dateNoteRepository.getAllByUsersByUserAndDate(user, date);
        } catch (Exception ex) {
            return null;
        }
    }
}
