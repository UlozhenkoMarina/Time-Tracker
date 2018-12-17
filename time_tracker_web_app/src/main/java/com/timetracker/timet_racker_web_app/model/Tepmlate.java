package com.timetracker.timet_racker_web_app.model;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "tepmlates", schema = "timetrackerdb")
public class Tepmlate {
    private int id;
    private Timestamp date;
    private Integer category;
    private byte splitted;
    private Integer priority;
    private byte notificate;
    private int duration;
    private int notFor;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
    @Column(name = "category", nullable = true)
    public Integer getCategory() {
        return category;
    }

    public void setCategory(Integer category) {
        this.category = category;
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

        Tepmlate tepmlate = (Tepmlate) o;

        if (id != tepmlate.id) return false;
        if (splitted != tepmlate.splitted) return false;
        if (notificate != tepmlate.notificate) return false;
        if (duration != tepmlate.duration) return false;
        if (notFor != tepmlate.notFor) return false;
        if (date != null ? !date.equals(tepmlate.date) : tepmlate.date != null) return false;
        if (category != null ? !category.equals(tepmlate.category) : tepmlate.category != null) return false;
        if (priority != null ? !priority.equals(tepmlate.priority) : tepmlate.priority != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (category != null ? category.hashCode() : 0);
        result = 31 * result + (int) splitted;
        result = 31 * result + (priority != null ? priority.hashCode() : 0);
        result = 31 * result + (int) notificate;
        result = 31 * result + duration;
        result = 31 * result + notFor;
        return result;
    }
}
