package com.timetracker.timet_racker_web_app.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "events", schema = "timetrackerdb")
public class Event {
    private int id;
    private String name;
    private String description;
    private Timestamp date;
    private byte splitted;
    private Integer priority;
    private byte done;
    private byte notificate;
    private int duration;
    private int notFor;
    private Collection<EventNote> eventNotesById;
    private Collection<EventPart> eventPartsById;
    private Category categoriesByCategory;
    private User usersByUser;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name", nullable = false, length = 45)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "description", nullable = true, length = 300)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "date", nullable = true)
    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    @Basic
    @Column(name = "splitted", nullable = false)
    public byte getSplitted() {
        return splitted;
    }

    public void setSplitted(byte splitted) {
        this.splitted = splitted;
    }

    @Basic
    @Column(name = "priority", nullable = true)
    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    @Basic
    @Column(name = "done", nullable = false)
    public byte getDone() {
        return done;
    }

    public void setDone(byte done) {
        this.done = done;
    }

    @Basic
    @Column(name = "notificate", nullable = false)
    public byte getNotificate() {
        return notificate;
    }

    public void setNotificate(byte notificate) {
        this.notificate = notificate;
    }

    @Basic
    @Column(name = "duration", nullable = false)
    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    @Basic
    @Column(name = "not_for", nullable = false)
    public int getNotFor() {
        return notFor;
    }

    public void setNotFor(int notFor) {
        this.notFor = notFor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Event event = (Event) o;
        return id == event.id &&
                splitted == event.splitted &&
                done == event.done &&
                notificate == event.notificate &&
                duration == event.duration &&
                notFor == event.notFor &&
                Objects.equals(name, event.name) &&
                Objects.equals(description, event.description) &&
                Objects.equals(date, event.date) &&
                Objects.equals(priority, event.priority);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name, description, date, splitted, priority, done, notificate, duration, notFor);
    }

    @OneToMany(mappedBy = "eventsByEvent")
    public Collection<EventNote> getEventNotesById() {
        return eventNotesById;
    }

    public void setEventNotesById(Collection<EventNote> eventNotesById) {
        this.eventNotesById = eventNotesById;
    }

    @OneToMany(mappedBy = "eventsByEvent")
    public Collection<EventPart> getEventPartsById() {
        return eventPartsById;
    }

    public void setEventPartsById(Collection<EventPart> eventPartsById) {
        this.eventPartsById = eventPartsById;
    }

    @ManyToOne
    @JoinColumn(name = "category", referencedColumnName = "id", nullable = true)
    public Category getCategoriesByCategory() {
        return categoriesByCategory;
    }

    public void setCategoriesByCategory(Category categoriesByCategory) {
        this.categoriesByCategory = categoriesByCategory;
    }

    @ManyToOne
    @JoinColumn(name = "user", referencedColumnName = "id", nullable = false)
    public User getUsersByUser() {
        return usersByUser;
    }

    public void setUsersByUser(User usersByUser) {
        this.usersByUser = usersByUser;
    }
}
