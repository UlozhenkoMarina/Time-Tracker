package com.timetracker.timet_racker_web_app.controller;


import com.timetracker.timet_racker_web_app.dao.service.EventService;
import com.timetracker.timet_racker_web_app.dao.service.GroupEventService;
import com.timetracker.timet_racker_web_app.dao.service.UserService;
import com.timetracker.timet_racker_web_app.form.EventForm;
import com.timetracker.timet_racker_web_app.form.GroupEventForm;
import com.timetracker.timet_racker_web_app.form.LoginForm;
import com.timetracker.timet_racker_web_app.form.RegisterForm;
import com.timetracker.timet_racker_web_app.model.Event;
import com.timetracker.timet_racker_web_app.model.GroupEvent;
import com.timetracker.timet_racker_web_app.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;


@Controller
public class UserController {

    @Autowired
    private EventService eventService;

    private User user=null;

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String viewLoginPage(Model model) {

        LoginForm form = new LoginForm();
        model.addAttribute("loginForm", form);
        return "loginPage";
    }

    @RequestMapping(value = { "/login" }, method = RequestMethod.POST)
    public String login(Model model, LoginForm form) {

        System.out.println(form.getEmail());
        user = userService.getUser(form.getEmail(), form.getPassword());
        if (user == null) {
            return "loginPage";
        } else {
            model.addAttribute("User", user);
        }
        return "userCabinet";
    }

    @RequestMapping(value = { "/logout" }, method = RequestMethod.POST)
    public String logout(Model model, LoginForm form) {
        System.out.println(form.getEmail());
        user = userService.getUser(form.getEmail(), form.getPassword());
        user=null;
        return "loginPage";
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String viewRegisterPage(Model model) {

        RegisterForm form = new RegisterForm();
        model.addAttribute("registerForm", form);
        return "registerPage";
    }

    @RequestMapping(value = { "/signup"}, method = RequestMethod.POST)
    public String register(Model model, RegisterForm form) {

        System.out.println(form.getEmail());
        //User user = new User();
        user=new User();
        user.setPassword(form.getPassword());
        user.setMobileNumber(form.getPhone());
        user.setEmail(form.getEmail());
        user.setName(form.getName());
        user.setSurname(form.getSurname());
        user.setUsername(form.getUsername());
        user.setCountry(form.getCountry());
        user.setCity(form.getCity());
        user = userService.addUser(user);
        if (user == null) {
            return "registerPage";
        } else {
            model.addAttribute("User", user);
        }
        return "userCabinet";
    }


    @RequestMapping(value = { "/userCabinet"}, method = RequestMethod.POST)
    public String userCabinetModify(Model model, RegisterForm form) {

        System.out.println(form.getEmail());
        //User user = new User();
        //user=new User();
        user.setPassword(form.getPassword());
        user.setMobileNumber(form.getPhone());
        user.setName(form.getName());
        user.setSurname(form.getSurname());
        user.setCountry(form.getCountry());
        user.setCity(form.getCity());
        user = userService.addUser(user);
        if (user == null) {
            return "registerPage";
        } else {
            user=userService.updateUser(user);
            model.addAttribute("User", user);
        }
        return "userCabinet";
    }



    @RequestMapping(value = { "/userCabinet"}, method = RequestMethod.GET)
    public String userCabinet(Model model, RegisterForm form) {

        System.out.println(form.getEmail());
        //User user = new User();
        //user=new User();
        user.getPassword();
        user.getMobileNumber();
        user.getEmail();
        user.getName();
        user.getSurname();
        user.getUsername();
        user.getCountry();
        user.getCity();
        user = userService.addUser(user);
        if (user == null) {
            return "registerPage";
        } else {
            model.addAttribute("User", user);
        }
        return "userCabinet";
    }

    // ------------------------------------------ EVENT CONTROLLER

    @RequestMapping(value = {"/createEvent"},method = RequestMethod.POST)
    public String createEvent(Model model, EventForm form) {
        Event event = new Event();
        // event.setCategoriesByCategory(form.getCategoriesByCategory());
        //event.setUsersByUser(user);
        event.setDate(form.getDate());
        event.setDescription(form.getDescription());
        event.setDone((byte)0);
        //    event.setDone(form.getDone());
        event.setDuration(form.getDuration());
        event.setEventNotesById(form.getEventNotesById());
        event.setName(form.getName());
        event.setPriority(form.getPriority());
        eventService.addEvent(user,event,form.getCategoriesByCategory());
        return "success";
    }


    @RequestMapping(value={"/getEvents"},method=RequestMethod.GET)
    public String getEvents(Model model){
        if (user!=null)
            model.addAttribute("allEvents",eventService.getEvents(user));
        return "event";
    }

    @RequestMapping(value ="/CreateEventForm",method = RequestMethod.GET)
    public String CreateEventForm(Model model){
        EventForm form=new EventForm();
        model.addAttribute("EventForm",form);
        return "success";
    }

    @RequestMapping(value="/getEventsByCategoryAndDate",method=RequestMethod.GET)
    public String getEventsByCategoryAndDate(Model model,EventForm form){
        model.addAttribute("EventsByCategoryAndDate",eventService.getEventsByCategoryAndDate(user,form.getCategoriesByCategory(),form.getDate()));
        return "success";
    }


    @RequestMapping(value="/getEventsByCategory",method=RequestMethod.GET)
    public String getEventsByCategory(Model model,EventForm form){
        model.addAttribute("EventsByCategory",eventService.getEventsByCategory(user,form.getCategoriesByCategory()));
        return "success";
    }

    // ------------------------------------------ GROUP CONTROLLER
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
    public String showGroupEvents(Model model) {
        List<GroupEvent> groupEvents = groupEventService.getGroupEvents(user);
        model.addAttribute("groupEvents", groupEvents);
      //  model.addAllAttributes("Users", )
        return  "group-events";
    }

    @RequestMapping(value = "/showConfirmedGroupEvents", method = RequestMethod.GET)
    public String showConfirmedGroupEvents(Model model) {
        List<GroupEvent> groupEvents = groupEventService.getConfirmedGroupEvents(user);
        model.addAttribute("groupEvents", groupEvents);
        return  "";
    }

    @RequestMapping(value = "/showInvitations", method = RequestMethod.GET)
    public String showInvitations(Model model) {
        List<GroupEvent> groupEvents = groupEventService.getInvitations(user);
        GroupEvent groupEvent = new GroupEvent();
        model.addAttribute("groupEvents", groupEvents);
        model.addAttribute("groupEvent", groupEvent);
        return  "";
    }

    @RequestMapping(value = "/acceptInvitations", method = RequestMethod.POST)
    public String acceptInvitations(Model model, GroupEvent event) {
        groupEventService.acceptInvitation(user, event);
        return  "";
    }

    @RequestMapping(value = "/getContacts", method = RequestMethod.GET)
    public String getContacts(Model model) {
        List<User> contacts = userService.getContactsUser(user);
        model.addAttribute("contacts", contacts);
        return "contacts";
    }

    @RequestMapping(value = "/addMember", method = RequestMethod.POST)
    public String addMember() {
        return "";
    }
}