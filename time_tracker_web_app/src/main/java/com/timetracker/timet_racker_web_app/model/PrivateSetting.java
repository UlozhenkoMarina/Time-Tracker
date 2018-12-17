package com.timetracker.timet_racker_web_app.model;

import javax.persistence.*;

@Entity
@Table(name = "private_settings", schema = "timetrackerdb")
public class PrivateSetting {
    private int id;
    private int review;
    private int groupRequests;

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

        if (id != that.id) return false;
        if (review != that.review) return false;
        if (groupRequests != that.groupRequests) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + review;
        result = 31 * result + groupRequests;
        return result;
    }
}
