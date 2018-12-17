package com.timetracker.timet_racker_web_app.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "event_notes", schema = "timetrackerdb")
public class EventNote {
    private int id;
    private String shortName;
    private String note;
    private Event eventsByEvent;
    private EventPart eventPartsByEventPart;

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
        return id == eventNote.id &&
                Objects.equals(shortName, eventNote.shortName) &&
                Objects.equals(note, eventNote.note);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, shortName, note);
    }

    @ManyToOne
    @JoinColumn(name = "event", referencedColumnName = "id", nullable = false)
    public Event getEventsByEvent() {
        return eventsByEvent;
    }

    public void setEventsByEvent(Event eventsByEvent) {
        this.eventsByEvent = eventsByEvent;
    }

    @ManyToOne
    @JoinColumn(name = "event_part", referencedColumnName = "id")
    public EventPart getEventPartsByEventPart() {
        return eventPartsByEventPart;
    }

    public void setEventPartsByEventPart(EventPart eventPartsByEventPart) {
        this.eventPartsByEventPart = eventPartsByEventPart;
    }
}
