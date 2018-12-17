package com.timetracker.timet_racker_web_app.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Objects;

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
    private Collection<GroupEventMember> groupEventMembersById;

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
        return id == that.id &&
                notificate == that.notificate &&
                notFor == that.notFor &&
                Objects.equals(name, that.name) &&
                Objects.equals(description, that.description) &&
                Objects.equals(date, that.date) &&
                Objects.equals(category, that.category) &&
                Objects.equals(priority, that.priority) &&
                Objects.equals(duration, that.duration) &&
                Objects.equals(reqsType, that.reqsType) &&
                Objects.equals(accepted, that.accepted);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name, description, date, category, priority, notificate, notFor, duration, reqsType, accepted);
    }

    @OneToMany(mappedBy = "groupEventsByEvent")
    public Collection<GroupEventMember> getGroupEventMembersById() {
        return groupEventMembersById;
    }

    public void setGroupEventMembersById(Collection<GroupEventMember> groupEventMembersById) {
        this.groupEventMembersById = groupEventMembersById;
    }
}
