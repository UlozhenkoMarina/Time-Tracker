package main.java.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "event_parts", schema = "timetrackerdb")
public class EventPart {
    private int id;
    private String partName;
    private String description;
    private Timestamp date;
    private byte done;
    private Integer duration;
    private Collection<EventNote> eventNotesById;
    private Event eventsByEvent;

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
        return id == eventPart.id &&
                done == eventPart.done &&
                Objects.equals(partName, eventPart.partName) &&
                Objects.equals(description, eventPart.description) &&
                Objects.equals(date, eventPart.date) &&
                Objects.equals(duration, eventPart.duration);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, partName, description, date, done, duration);
    }

    @OneToMany(mappedBy = "eventPartsByEventPart")
    public Collection<EventNote> getEventNotesById() {
        return eventNotesById;
    }

    public void setEventNotesById(Collection<EventNote> eventNotesById) {
        this.eventNotesById = eventNotesById;
    }

    @ManyToOne
    @JoinColumn(name = "event", referencedColumnName = "id", nullable = false)
    public Event getEventsByEvent() {
        return eventsByEvent;
    }

    public void setEventsByEvent(Event eventsByEvent) {
        this.eventsByEvent = eventsByEvent;
    }
}
