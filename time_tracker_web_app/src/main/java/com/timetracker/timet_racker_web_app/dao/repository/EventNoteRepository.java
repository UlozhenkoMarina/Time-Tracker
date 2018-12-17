package com.timetracker.timet_racker_web_app.dao.repository;

import com.timetracker.timet_racker_web_app.model.Event;
import com.timetracker.timet_racker_web_app.model.EventNote;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EventNoteRepository extends CrudRepository<EventNote, Long> {
    public List<EventNote> getAllByEventsByEvent(Event event);
}
