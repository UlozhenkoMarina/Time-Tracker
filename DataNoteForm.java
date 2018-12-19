package com.timetracker.timet_racker_web_app.form;

import com.timetracker.timet_racker_web_app.model.User;

import java.sql.Timestamp;

public class DataNoteForm {
    private String shortName;
    private String note;
    private Timestamp date;
    private User usersByUser;

    public String getShortName() {
        return shortName;
    }

    public String getNote(){
        return note;
    }

    public void setShortName(String shortName){
        this.shortName=shortName;
    }

    public void setNote(String note){
        this.note=note;
    }

    public void setDate(Timestamp date){
        this.date=date;
    }

    public Timestamp getDate(){
        return this.date;
    }

    public void setUsersByUser(User usersByUser) {
        this.usersByUser = usersByUser;
    }

    public User getUsersByUser() {
        return usersByUser;
    }
}
