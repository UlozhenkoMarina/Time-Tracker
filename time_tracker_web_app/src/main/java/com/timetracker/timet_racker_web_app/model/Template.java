package com.timetracker.timet_racker_web_app.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "tepmlates", schema = "timetrackerdb")
public class Template {
    private int id;
    private Timestamp date;
    private Integer category;
    private byte splitted;
    private Integer priority;
    private byte notificate;
    private int duration;
    private int notFor;
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
        Template template = (Template) o;
        return id == template.id &&
                splitted == template.splitted &&
                notificate == template.notificate &&
                duration == template.duration &&
                notFor == template.notFor &&
                Objects.equals(date, template.date) &&
                Objects.equals(category, template.category) &&
                Objects.equals(priority, template.priority);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, date, category, splitted, priority, notificate, duration, notFor);
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
