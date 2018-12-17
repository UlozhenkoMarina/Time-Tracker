package com.timetracker.timet_racker_web_app.model;

import javax.persistence.*;
import java.sql.Timestamp;

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
    private Category categoriesByCategory;

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

        if (id != event.id) return false;
        if (splitted != event.splitted) return false;
        if (done != event.done) return false;
        if (notificate != event.notificate) return false;
        if (duration != event.duration) return false;
        if (notFor != event.notFor) return false;
        if (name != null ? !name.equals(event.name) : event.name != null) return false;
        if (description != null ? !description.equals(event.description) : event.description != null) return false;
        if (date != null ? !date.equals(event.date) : event.date != null) return false;
        if (priority != null ? !priority.equals(event.priority) : event.priority != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (int) splitted;
        result = 31 * result + (priority != null ? priority.hashCode() : 0);
        result = 31 * result + (int) done;
        result = 31 * result + (int) notificate;
        result = 31 * result + duration;
        result = 31 * result + notFor;
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "category", referencedColumnName = "id")
    public Category getCategoriesByCategory() {
        return categoriesByCategory;
    }

    public void setCategoriesByCategory(Category categoriesByCategory) {
        this.categoriesByCategory = categoriesByCategory;
    }
}
