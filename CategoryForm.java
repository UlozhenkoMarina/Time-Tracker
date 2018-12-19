package com.timetracker.timet_racker_web_app.form;

import com.timetracker.timet_racker_web_app.model.Event;
import com.timetracker.timet_racker_web_app.model.User;

import java.util.Collection;

public class CategoryForm {
    private String category;
   // private byte system;
    private User user;
    private Collection<Event> eventsById;


    public void setCategory(String category){
        this.category=category;
    }

    public String getCategory() {
        return this.category;
    }

//    public byte getSystem(){
//        return  this.system;
//    }
//    public void setSystem(byte system){
//        this.system=system;
//    }

    public User getUser(){
        return this.user;
    }
    public void setUser(User user){
        this.user=user;
    }

    public Collection<Event> getEventById(){
        return this.eventsById;
    }
    public void setEventsById(Collection<Event> eventsById){
        this.eventsById=eventsById;
    }

}
