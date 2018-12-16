package main.java.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "contacts", schema = "timetrackerdb")
public class Contact {
    private int id;
    private byte blocked;
    private User usersByUserOwner;
    private User usersByContact;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "blocked", nullable = false)
    public byte getBlocked() {
        return blocked;
    }

    public void setBlocked(byte blocked) {
        this.blocked = blocked;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contact contact = (Contact) o;
        return id == contact.id &&
                blocked == contact.blocked;
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, blocked);
    }

    @ManyToOne
    @JoinColumn(name = "user_owner", referencedColumnName = "id", nullable = false)
    public User getUsersByUserOwner() {
        return usersByUserOwner;
    }

    public void setUsersByUserOwner(User usersByUserOwner) {
        this.usersByUserOwner = usersByUserOwner;
    }

    @ManyToOne
    @JoinColumn(name = "contact", referencedColumnName = "id", nullable = false)
    public User getUsersByContact() {
        return usersByContact;
    }

    public void setUsersByContact(User usersByContact) {
        this.usersByContact = usersByContact;
    }
}
