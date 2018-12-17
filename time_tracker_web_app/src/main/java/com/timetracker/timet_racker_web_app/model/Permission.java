package com.timetracker.timet_racker_web_app.model;

import javax.persistence.*;

@Entity
@Table(name = "permissions", schema = "timetrackerdb")
public class Permission {
    private int id;
    private int permissionType;

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

        if (id != that.id) return false;
        if (permissionType != that.permissionType) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + permissionType;
        return result;
    }
}
