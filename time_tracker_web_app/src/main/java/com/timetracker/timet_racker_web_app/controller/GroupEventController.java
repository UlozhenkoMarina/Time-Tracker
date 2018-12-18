package com.timetracker.timet_racker_web_app.controller;

import com.timetracker.timet_racker_web_app.dao.service.GroupEventService;
import com.timetracker.timet_racker_web_app.form.GroupEventForm;
import com.timetracker.timet_racker_web_app.model.GroupEvent;
import com.timetracker.timet_racker_web_app.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;


@Controller
public class GroupEventController {

    @Autowired
    private GroupEventService groupEventService;

    @RequestMapping(value = "/createGroupEvent", method = RequestMethod.GET)
    public String viewGroupEventPage(Model model) {
        GroupEventForm groupEventForm = new GroupEventForm();
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
        groupEventService.createGroupEvent(event, form.getMembers());
        return "";
    }

    @RequestMapping(value = "/showGroupEvents", method = RequestMethod.GET)
    public String showGroupEvents(Model model, User user) {
        List<GroupEvent> groupEvents = groupEventService.getGroupEvents(user);
        model.addAttribute("groupEvents", groupEvents);
        return  "";
    }


}
