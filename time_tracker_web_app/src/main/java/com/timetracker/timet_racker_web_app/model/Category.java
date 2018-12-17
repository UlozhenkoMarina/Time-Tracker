package com.timetracker.timet_racker_web_app.model;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "categories", schema = "timetrackerdb")
public class Category {
    private int id;
    private String category;
    private byte system;
    private User user;
    private Collection<Event> eventsById;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "category", nullable = true, length = 45)
    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Basic
    @Column(name = "system", nullable = false)
    public byte getSystem() {
        return system;
    }

    public void setSystem(byte system) {
        this.system = system;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Category category1 = (Category) o;
        return id == category1.id &&
                system == category1.system &&
                Objects.equals(category, category1.category);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, category, system);
    }

    @ManyToOne
    @JoinColumn(name = "user", referencedColumnName = "id")
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @OneToMany(mappedBy = "categoriesByCategory")
    public Collection<Event> getEventsById() {
        return eventsById;
    }

    public void setEventsById(Collection<Event> eventsById) {
        this.eventsById = eventsById;
    }
}
