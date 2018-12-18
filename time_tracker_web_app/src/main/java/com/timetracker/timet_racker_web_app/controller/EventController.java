package com.timetracker.timet_racker_web_app.controller;

import com.timetracker.timet_racker_web_app.dao.service.EventService;
import com.timetracker.timet_racker_web_app.form.EventForm;
import com.timetracker.timet_racker_web_app.model.Event;
import com.timetracker.timet_racker_web_app.model.User;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public class EventController {


private EventService eventService;

@RequestMapping(value = {"/createEvent"},method = RequestMethod.POST)
public String createEvent(Model model, EventForm form,User user) {
    Event event = new Event();
   // event.setCategoriesByCategory(form.getCategoriesByCategory());
    //event.setUsersByUser(user);
    event.setDate(form.getDate());
    event.setDescription(form.getDescription());
    event.setDone(form.getDone());
    event.setDuration(form.getDuration());
    event.setEventNotesById(form.getEventNotesById());
    event.setName(form.getName());
    event.setPriority(form.getPriority());
    eventService.addEvent(user,event,form.getCategoriesByCategory());
    return "success";
}


@RequestMapping(value="/getEvents",method=RequestMethod.GET)
    public String getEvents(Model model, User user){
    model.addAllAttributes(eventService.getEvents(user));
    return "success";
}

    @RequestMapping(value="/getEventsByCategoryAndDate",method=RequestMethod.GET)
    public String getEventsByCategoryAndDate(Model model, User user,EventForm form){
        model.addAllAttributes(eventService.getEventsByCategoryAndDate(user,form.getCategoriesByCategory(),form.getDate()));
        return "success";
    }


    @RequestMapping(value="/getEventsByCategory",method=RequestMethod.GET)
    public String getEventsByCategory(Model model, User user,EventForm form){
        model.addAllAttributes(eventService.getEventsByCategory(user,form.getCategoriesByCategory()));
        return "success";
    }


}
