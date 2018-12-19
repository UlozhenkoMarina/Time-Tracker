package com.timetracker.timet_racker_web_app.form;

import com.timetracker.timet_racker_web_app.model.Category;
import com.timetracker.timet_racker_web_app.model.EventNote;
import com.timetracker.timet_racker_web_app.model.User;

import java.sql.Timestamp;
import java.util.Collection;
import java.util.Date;

public class EventForm {
    private String name;
    private String description;
    private Timestamp date;
   // private byte splitted;
    private Integer priority;
    private byte done;
    private byte notificate;
    private int duration;
   // private int notFor;
    private Collection<EventNote> eventNotesById;
   // private Collection<EventPart> eventPartsById;
    private Category categoriesByCategory;
    private User usersByUser;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description){
        this.description=description;
    }

    public String getDescription(){
        return this.description;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date){
        this.date=date;
    }

//    public void setSplitted(Byte splitted){
//        this.splitted=splitted;
//    }
//
//    public Byte getSplitted(){
//        return this.splitted;
//    }

    public Integer getPriority() {
        return this.priority;
    }

    public void setPriority(Integer priority){
        this.priority=priority;
    }


    public void setDone(Byte done){
        this.done=done;
    }

    public byte getDone() {
        return this.done;
    }

    public void setNotificate(Byte notificate){
        this.notificate=notificate;
    }

    public byte getNotificate() {
        return this.notificate;
    }

    public int getDuration(){
        return this.duration;
    }

    public void setDuration(int duration){
        this.duration=duration;
    }


//    public int getNotFor(){
//        return this.notFor;
//    }
//
//    public void setNotFor(int notFor){
//        this.notFor=notFor;
//    }

    public Collection<EventNote> getEventNotesById(){
        return this.eventNotesById;
    }

    public void setEventNotesById(Collection<EventNote> eventNotesById) {
        this.eventNotesById = eventNotesById;
    }

//    public void setEventPartsById(Collection<EventPart> eventPartsById) {
//        this.eventPartsById = eventPartsById;
//    }
//
//    public Collection<EventPart> getEventPartsById() {
//        return eventPartsById;
//    }

    public void setCategoriesByCategory(Category categoriesByCategory){
        this.categoriesByCategory=categoriesByCategory;
    }

    public Category getCategoriesByCategory() {
        return categoriesByCategory;
    }

    public User getUsersByUser() {
        return this.usersByUser;
    }

    public void setUsersByUser(User usersByUser) {
        this.usersByUser = usersByUser;
    }
}
