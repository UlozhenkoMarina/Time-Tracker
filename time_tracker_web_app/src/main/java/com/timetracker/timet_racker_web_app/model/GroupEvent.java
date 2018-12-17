package com.timetracker.timet_racker_web_app.model;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "group_events", schema = "timetrackerdb")
public class GroupEvent {
    private int id;
    private String name;
    private String description;
    private Timestamp date;
    private Integer category;
    private Integer priority;
    private byte notificate;
    private int notFor;
    private Integer duration;
    private String reqsType;
    private Byte accepted;

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
    @Column(name = "category", nullable = true)
    public Integer getCategory() {
        return category;
    }

    public void setCategory(Integer category) {
        this.category = category;
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
    @Column(name = "not_for", nullable = false)
    public int getNotFor() {
        return notFor;
    }

    public void setNotFor(int notFor) {
        this.notFor = notFor;
    }

    @Basic
    @Column(name = "duration", nullable = true)
    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    @Basic
    @Column(name = "reqs_type", nullable = true, length = 45)
    public String getReqsType() {
        return reqsType;
    }

    public void setReqsType(String reqsType) {
        this.reqsType = reqsType;
    }

    @Basic
    @Column(name = "accepted", nullable = true)
    public Byte getAccepted() {
        return accepted;
    }

    public void setAccepted(Byte accepted) {
        this.accepted = accepted;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GroupEvent that = (GroupEvent) o;

        if (id != that.id) return false;
        if (notificate != that.notificate) return false;
        if (notFor != that.notFor) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (date != null ? !date.equals(that.date) : that.date != null) return false;
        if (category != null ? !category.equals(that.category) : that.category != null) return false;
        if (priority != null ? !priority.equals(that.priority) : that.priority != null) return false;
        if (duration != null ? !duration.equals(that.duration) : that.duration != null) return false;
        if (reqsType != null ? !reqsType.equals(that.reqsType) : that.reqsType != null) return false;
        if (accepted != null ? !accepted.equals(that.accepted) : that.accepted != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (category != null ? category.hashCode() : 0);
        result = 31 * result + (priority != null ? priority.hashCode() : 0);
        result = 31 * result + (int) notificate;
        result = 31 * result + notFor;
        result = 31 * result + (duration != null ? duration.hashCode() : 0);
        result = 31 * result + (reqsType != null ? reqsType.hashCode() : 0);
        result = 31 * result + (accepted != null ? accepted.hashCode() : 0);
        return result;
    }
}
