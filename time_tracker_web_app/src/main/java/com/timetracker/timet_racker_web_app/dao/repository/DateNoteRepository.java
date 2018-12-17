package com.timetracker.timet_racker_web_app.dao.repository;

import com.timetracker.timet_racker_web_app.model.DateNote;
import com.timetracker.timet_racker_web_app.model.User;
import org.springframework.data.repository.CrudRepository;

import java.sql.Timestamp;
import java.util.List;

public interface DateNoteRepository extends CrudRepository<DateNote, Long> {
    public List<DateNote> getAllByUsersByUser(User user);
    public List<DateNote> getAllByUsersByUserAndDate(User user, Timestamp date);
}
