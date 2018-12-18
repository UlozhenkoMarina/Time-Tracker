package com.timetracker.timet_racker_web_app.controller;

import com.timetracker.timet_racker_web_app.dao.service.GroupEventService;
import com.timetracker.timet_racker_web_app.dao.service.UserService;
import com.timetracker.timet_racker_web_app.form.GroupEventForm;
import com.timetracker.timet_racker_web_app.model.GroupEvent;
import com.timetracker.timet_racker_web_app.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;


@Controller
public class GroupEventController {

    @Autowired
    private GroupEventService groupEventService;

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/createGroupEvent", method = RequestMethod.GET)
    public String viewGroupEventPage(Model model) {
        GroupEventForm groupEventForm = new GroupEventForm();
        groupEventForm.setMembers(userService.getContacts(user));
        model.addAttribute("groupEventForm", groupEventForm);
        return "groupEventPage";
    }

    @RequestMapping(value = "/submitGroupEvent", method = RequestMethod.POST)
    public String addGroupEvent(Model model, GroupEventForm form) {
        GroupEvent event = new GroupEvent();
        event.setDate(form.getDate());
        event.setName(form.getName());
        event.setDescription(form.getDescription());
        event.setDuration(form.getDuration());
        event.setCategory(form.getCategory());
        event.setPriority(form.getPriority());
        List<User> members = new ArrayList<>();
        for (int i = 0; i <form.getMembers().size(); i++) {
            if (form.getChecked()[i] == 1) {
                members.add(form.getMembers().get(i));
            }
        }
        groupEventService.createGroupEvent(event, members);
        return "";
    }

    @RequestMapping(value = "/showGroupEvents", method = RequestMethod.GET)
    public String showGroupEvents(Model model, User user) {
        List<GroupEvent> groupEvents = groupEventService.getGroupEvents(user);
        model.addAttribute("groupEvents", groupEvents);
        return  "";
    }

    @RequestMapping(value = "/showConfirmedGroupEvents", method = RequestMethod.GET)
    public String showConfirmedGroupEvents(Model model, User user) {
        List<GroupEvent> groupEvents = groupEventService.getConfirmedGroupEvents(user);
        model.addAttribute("groupEvents", groupEvents);
        return  "";
    }

    @RequestMapping(value = "/showInvitations", method = RequestMethod.GET)
    public String showInvitations(Model model, User user) {
        List<GroupEvent> groupEvents = groupEventService.getInvitations(user);
        GroupEvent groupEvent = new GroupEvent();
        model.addAttribute("groupEvents", groupEvents);
        model.addAttribute("groupEvent", groupEvent);
        return  "";
    }

    @RequestMapping(value = "/acceptInvitations", method = RequestMethod.POST)
    public String acceptInvitations(Model model, User user, GroupEvent event) {
        groupEventService.acceptInvitation(user, event);
        return  "";
    }

}
