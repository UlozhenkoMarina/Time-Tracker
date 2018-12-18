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



//    @RequestMapping(value="/createCategory",method = RequestMethod.POST)
//    public String createCategory(Model model){
//
//        return "success";
//    }


}
