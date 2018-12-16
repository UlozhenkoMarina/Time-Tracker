package main.java.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "date_notes", schema = "timetrackerdb")
public class DateNote {
    private int id;
    private String shortName;
    private String note;
    private Timestamp date;
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

    @Basic
    @Column(name = "date", nullable = false)
    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DateNote dateNote = (DateNote) o;
        return id == dateNote.id &&
                Objects.equals(shortName, dateNote.shortName) &&
                Objects.equals(note, dateNote.note) &&
                Objects.equals(date, dateNote.date);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, shortName, note, date);
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
