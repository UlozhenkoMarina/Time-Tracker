package com.timetracker.timet_racker_web_app.model;

import javax.persistence.*;

@Entity
@Table(name = "group_event_members", schema = "timetrackerdb")
public class GroupEventMember {
    private int id;
    private byte req;
    private byte accepted;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "req", nullable = false)
    public byte getReq() {
        return req;
    }

    public void setReq(byte req) {
        this.req = req;
    }

    @Basic
    @Column(name = "accepted", nullable = false)
    public byte getAccepted() {
        return accepted;
    }

    public void setAccepted(byte accepted) {
        this.accepted = accepted;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GroupEventMember that = (GroupEventMember) o;

        if (id != that.id) return false;
        if (req != that.req) return false;
        if (accepted != that.accepted) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (int) req;
        result = 31 * result + (int) accepted;
        return result;
    }
}
