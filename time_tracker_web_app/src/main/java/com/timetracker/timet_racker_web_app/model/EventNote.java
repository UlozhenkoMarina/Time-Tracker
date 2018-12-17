package com.timetracker.timet_racker_web_app.model;

import javax.persistence.*;

@Entity
@Table(name = "event_notes", schema = "timetrackerdb")
public class EventNote {
    private int id;
    private String shortName;
    private String note;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "short_name", nullable = true, length = 45)
    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    @Basic
    @Column(name = "note", nullable = false, length = 300)
    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EventNote eventNote = (EventNote) o;

        if (id != eventNote.id) return false;
        if (shortName != null ? !shortName.equals(eventNote.shortName) : eventNote.shortName != null) return false;
        if (note != null ? !note.equals(eventNote.note) : eventNote.note != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (shortName != null ? shortName.hashCode() : 0);
        result = 31 * result + (note != null ? note.hashCode() : 0);
        return result;
    }
}
