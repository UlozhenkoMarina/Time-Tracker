package com.timetracker.timet_racker_web_app.dao.repository;

import com.timetracker.timet_racker_web_app.model.GroupEvent;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface GroupEventRepository extends CrudRepository<GroupEvent, Long> {
    public GroupEvent getGroupEventById(long id);
    public List<GroupEvent> getAllByAccepted(byte accepted);
}
