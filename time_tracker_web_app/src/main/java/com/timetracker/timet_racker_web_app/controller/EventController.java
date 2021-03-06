package com.timetracker.timet_racker_web_app.controller;

import com.timetracker.timet_racker_web_app.dao.service.EventService;
import com.timetracker.timet_racker_web_app.form.CategoryForm;
import com.timetracker.timet_racker_web_app.form.DataNoteForm;
import com.timetracker.timet_racker_web_app.form.EventForm;
import com.timetracker.timet_racker_web_app.model.Category;
import com.timetracker.timet_racker_web_app.model.DateNote;
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
    return "createEvent";
}


@RequestMapping(value = "/createEvent",method = RequestMethod.POST)
public String createEvent(Model model, EventForm form,User user) {
    Event event = new Event();
    //event.setCategoriesByCategory(form.getCategoriesByCategory());
    //event.setUsersByUser(user);
    event.setDate(form.getDate());
    event.setDescription(form.getDescription());
    //event.setDone(form.getDone());
    event.setDone((byte)0);
    event.setDuration(form.getDuration());
    event.setEventNotesById(form.getEventNotesById());
    event.setName(form.getName());
    event.setPriority(form.getPriority());
    eventService.addEvent(user,event,form.getCategoriesByCategory());
    return "success";
}


@RequestMapping(value="/getEvents",method=RequestMethod.GET)
    public String getEvents(Model model, User user){
    if (user!=null)
        model.addAttribute("allEvents",eventService.getEvents(user));
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



    @RequestMapping(value ="/preCreateCategory",method = RequestMethod.GET)
    public String CreateCategoryForm(Model model){
        CategoryForm form=new CategoryForm();
        model.addAttribute("CategoryForm",form);
        return "createCategory";
    }

    @RequestMapping(value="/createCategory",method = RequestMethod.POST)
    public String createCategory(Model model,CategoryForm form){
        Category category=new Category();
        category.setCategory(form.getCategory());
        category.setSystem((byte)1);
        //category.setSystem(form.getSystem());
        category.setUser(form.getUser());
        category.setEventsById(form.getEventById());
        eventService.addCategory(category);
        return "success";
    }

    @RequestMapping(value = "/getSystemCategories",method = RequestMethod.GET)
    public String getSystemCategories(Model model){
        model.addAttribute("systemCategories", eventService.getSystemCategories());
        return "success";
    }


    @RequestMapping(value = "/getUserCategories",method = RequestMethod.GET)
    public String getUserCategories(Model model,User user){
        model.addAttribute("userCategories", eventService.getUserCategories(user.getId()));
        return "success";
    }


    @RequestMapping(value="/createDateNone",method = RequestMethod.POST)
    public String createDateNone(Model model, DataNoteForm form){
        DateNote dateNote=new DateNote();
        dateNote.setShortName(form.getShortName());
        dateNote.setDate(form.getDate());
        // dateNote.setUsersByUser(form.getUsersByUser());
        eventService.addDataNotes(user,dateNote);
        return "success";
    }


    @RequestMapping(value="/getDateNone",method = RequestMethod.GET)
    public String getDateNotes(Model model, DataNoteForm form){
        model.addAttribute(eventService.getDateNotes(user));

        return "success";
    }
}
