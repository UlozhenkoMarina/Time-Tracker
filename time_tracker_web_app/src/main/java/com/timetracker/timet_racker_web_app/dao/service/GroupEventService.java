package com.timetracker.timet_racker_web_app.dao.service;

import com.timetracker.timet_racker_web_app.dao.repository.GroupEventMemberRepository;
import com.timetracker.timet_racker_web_app.dao.repository.GroupEventRepository;
import com.timetracker.timet_racker_web_app.model.GroupEvent;
import com.timetracker.timet_racker_web_app.model.GroupEventMember;
import com.timetracker.timet_racker_web_app.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class GroupEventService {

    @Autowired
    private GroupEventMemberRepository memberRepository;

    @Autowired
    private GroupEventRepository groupEventRepository;

    public List<GroupEvent> getGroupEvents(User user) {
        List<GroupEventMember>  members = memberRepository.getAllByUsersByUser(user);
        List<GroupEvent> groupEvents = new ArrayList<>();
        for (GroupEventMember m : members) {
            groupEvents.add(groupEventRepository.findById(m.getGroupEventsByEvent().getId()).get());
        }
        return groupEvents;
    }

    public List<GroupEvent> getInvintations(User user) {
        List<GroupEventMember>  members = memberRepository.getAllByUsersByUserAndAccepted(user, (byte)0);
        List<GroupEvent> groupEvents = new ArrayList<>();
        for (GroupEventMember m : members) {
            groupEvents.add(groupEventRepository.findById(m.getGroupEventsByEvent().getId()).get());
        }
        return groupEvents;
    }

    public List<GroupEvent> getConfirmedGroupEvents(User user) {
        List<GroupEventMember>  members = memberRepository.getAllByUsersByUser(user);
        List<GroupEvent> groupEvents = new ArrayList<>();
        for (GroupEventMember m : members) {
            GroupEvent groupEvent = groupEventRepository.findById(m.getGroupEventsByEvent().getId()).get();
            if (groupEvent.getAccepted() == (byte)1) {
                groupEvents.add(groupEvent);
            }
        }
        return groupEvents;
    }

    public void createGroupEvent(GroupEvent groupEvent, List<User> members) {
        groupEvent = groupEventRepository.save(groupEvent);
        for (User member : members) {
            GroupEventMember groupEventMember = new GroupEventMember();
            groupEventMember.setUsersByUser(member);
            groupEventMember.setGroupEventsByEvent(groupEvent);
            memberRepository.save(groupEventMember);
        }
    }

    public void acceptInvintation(User user, GroupEvent groupEvent) {
        GroupEventMember member = memberRepository.getByUsersByUserAndGroupEventsByEvent(user, groupEvent);
        member.setAccepted((byte)1);
        memberRepository.save(member);
        List<GroupEventMember> members = memberRepository.getAllByGroupEventsByEvent(groupEvent);
        boolean flag = true;
        for (GroupEventMember m : members) {
            if (m.getAccepted() == (byte)0) {
                flag = false;
            }
        }
        if (flag) {
            GroupEvent event = groupEventRepository.findById(groupEvent.getId()).get();
            event.setAccepted((byte)1);
            groupEventRepository.save(event);
        }
    }
}
