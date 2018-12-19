package com.timetracker.timet_racker_web_app.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "private_settings", schema = "timetrackerdb")
public class PrivateSetting {
    private int id;
    private int review;
    private int groupRequests;
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
    @Column(name = "review", nullable = false)
    public int getReview() {
        return review;
    }

    public void setReview(int review) {
        this.review = review;
    }

    @Basic
    @Column(name = "group_requests", nullable = false)
    public int getGroupRequests() {
        return groupRequests;
    }

    public void setGroupRequests(int groupRequests) {
        this.groupRequests = groupRequests;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PrivateSetting that = (PrivateSetting) o;
        return id == that.id &&
                review == that.review &&
                groupRequests == that.groupRequests;
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, review, groupRequests);
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
