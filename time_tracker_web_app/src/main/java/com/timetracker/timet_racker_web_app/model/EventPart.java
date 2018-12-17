package com.timetracker.timet_racker_web_app.model;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "event_parts", schema = "timetrackerdb")
public class EventPart {
    private int id;
    private String partName;
    private String description;
    private Timestamp date;
    private byte done;
    private Integer duration;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "part_name", nullable = false, length = 45)
    public String getPartName() {
        return partName;
    }

    public void setPartName(String partName) {
        this.partName = partName;
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
    @Column(name = "date", nullable = false)
    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
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
    @Column(name = "duration", nullable = true)
    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EventPart eventPart = (EventPart) o;

        if (id != eventPart.id) return false;
        if (done != eventPart.done) return false;
        if (partName != null ? !partName.equals(eventPart.partName) : eventPart.partName != null) return false;
        if (description != null ? !description.equals(eventPart.description) : eventPart.description != null)
            return false;
        if (date != null ? !date.equals(eventPart.date) : eventPart.date != null) return false;
        if (duration != null ? !duration.equals(eventPart.duration) : eventPart.duration != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (partName != null ? partName.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (int) done;
        result = 31 * result + (duration != null ? duration.hashCode() : 0);
        return result;
    }
}
