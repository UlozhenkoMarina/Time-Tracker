package com.timetracker.timet_racker_web_app.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "permissions", schema = "timetrackerdb")
public class Permission {
    private int id;
    private int permissionType;
    private User usersByUserOwner;
    private User usersByUserAb;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "permission_type", nullable = false)
    public int getPermissionType() {
        return permissionType;
    }

    public void setPermissionType(int permissionType) {
        this.permissionType = permissionType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Permission that = (Permission) o;
        return id == that.id &&
                permissionType == that.permissionType;
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, permissionType);
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
    @JoinColumn(name = "user_ab", referencedColumnName = "id", nullable = false)
    public User getUsersByUserAb() {
        return usersByUserAb;
    }

    public void setUsersByUserAb(User usersByUserAb) {
        this.usersByUserAb = usersByUserAb;
    }
}
