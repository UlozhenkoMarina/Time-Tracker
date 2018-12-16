package main.java.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "group_event_members", schema = "timetrackerdb")
public class GroupEventMember {
    private int id;
    private byte req;
    private byte accepted;
    private User usersByUser;
    private GroupEvent groupEventsByEvent;

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
        return id == that.id &&
                req == that.req &&
                accepted == that.accepted;
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, req, accepted);
    }

    @ManyToOne
    @JoinColumn(name = "user", referencedColumnName = "id", nullable = false)
    public User getUsersByUser() {
        return usersByUser;
    }

    public void setUsersByUser(User usersByUser) {
        this.usersByUser = usersByUser;
    }

    @ManyToOne
    @JoinColumn(name = "event", referencedColumnName = "id", nullable = false)
    public GroupEvent getGroupEventsByEvent() {
        return groupEventsByEvent;
    }

    public void setGroupEventsByEvent(GroupEvent groupEventsByEvent) {
        this.groupEventsByEvent = groupEventsByEvent;
    }
}
