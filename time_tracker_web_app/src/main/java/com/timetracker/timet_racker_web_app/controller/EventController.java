package com.timetracker.timet_racker_web_app.controller;

import com.timetracker.timet_racker_web_app.dao.service.EventService;
import com.timetracker.timet_racker_web_app.form.EventForm;
import com.timetracker.timet_racker_web_app.model.Event;
import com.timetracker.timet_racker_web_app.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class EventController {

@Autowired
private EventService eventService;


@RequestMapping(value ="/CreateEventForm",method = RequestMethod.GET)
public String CreateEventForm(Model model){
    EventForm form=new EventForm();
    model.addAttribute("EventForm",form);
    return "success";
}

    @RequestMapping(value="/getEventsByCategoryAndDate",method=RequestMethod.GET)
    public String getEventsByCategoryAndDate(Model model, User user,EventForm form){
        model.addAttribute("EventsByCategoryAndDate",eventService.getEventsByCategoryAndDate(user,form.getCategoriesByCategory(),form.getDate()));
        return "success";
    }


    @RequestMapping(value="/getEventsByCategory",method=RequestMethod.GET)
    public String getEventsByCategory(Model model, User user,EventForm form){
        model.addAttribute("EventsByCategory",eventService.getEventsByCategory(user,form.getCategoriesByCategory()));
        return "success";
    }


//    @RequestMapping(value="/createCategory",method = RequestMethod.POST)
//    public String createCategory(Model model){
//
//        return "success";
//    }


}
