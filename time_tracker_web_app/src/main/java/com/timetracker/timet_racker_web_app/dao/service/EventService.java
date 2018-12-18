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
        return categoryRepository.getAllBySystem((byte)1);
    }

    public List<Category> getUserCategories(long id) {
        User user = userRepository.getUserById(id);
        return (List<Category>) user.getCategoriesById();
    }

    public List<Event> getEventsByCategoryAndDate(User user, Category category, Timestamp date) {
        return  eventRepository.getAllByDateAndUsersByUserAndCategoriesByCategory(date, user, category);
    }

    public List<Event> getEventsByCategory(User user, Category category) {
        return eventRepository.getAllByUsersByUserAndCategoriesByCategory(user, category);
    }

    public List<Event> getEventsByDate(User user, Timestamp date) {
        return eventRepository.getAllByUsersByUserAndDate(user, date);
    }

    public List<Event> getEvents(User user) {
        user = userRepository.getUserById(user.getId());
        return eventRepository.getAllByUsersByUser(user);
    }

    public void updateEvent(Event event) {
        eventRepository.save(event);
    }

    public void addEvent(User user, Event event, Category category) {
        event.setUsersByUser(user);
        event.setCategoriesByCategory(category);
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
        return dateNoteRepository.getAllByUsersByUser(user);
    }

    public List<DateNote> getDateNotes(User user, Timestamp date) {
        List<DateNote> list = dateNoteRepository.getAllByUsersByUserAndDate(user, date);
        return dateNoteRepository.getAllByUsersByUserAndDate(user, date);
    }
}
