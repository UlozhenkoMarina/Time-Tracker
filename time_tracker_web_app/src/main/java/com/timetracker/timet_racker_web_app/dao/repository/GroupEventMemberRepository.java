package com.timetracker.timet_racker_web_app.dao.repository;

import com.timetracker.timet_racker_web_app.model.GroupEvent;
import com.timetracker.timet_racker_web_app.model.GroupEventMember;
import com.timetracker.timet_racker_web_app.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface GroupEventMemberRepository extends CrudRepository<GroupEventMember, Integer> {
    public List<GroupEventMember> getAllByUsersByUser(User user);
    public List<GroupEventMember> getAllByGroupEventsByEvent(GroupEvent event);
    public List<GroupEventMember> getAllByUsersByUserAndAccepted(User user, byte accepted);
    public GroupEventMember getByUsersByUserAndGroupEventsByEvent(User user, GroupEvent event);
}
