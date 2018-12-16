package main.java.model;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "users", schema = "timetrackerdb")
public class User {
    private int id;
    private String username;
    private String email;
    private String name;
    private String surname;
    private String mobileNumber;
    private String password;
    private String country;
    private String city;
    private Integer notifications;
    private Collection<Category> categoriesById;
    private Collection<Contact> contactsById;
    private Collection<Contact> contactsById_0;
    private Collection<DateNote> dateNotesById;
    private Collection<Event> eventsById;
    private Collection<GroupEventMember> groupEventMembersById;
    private Collection<Permission> permissionsById;
    private Collection<Permission> permissionsById_0;
    private Collection<PrivateSetting> privateSettingsById;
    private Collection<Template> tepmlatesById;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "username", nullable = false, length = 45)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Basic
    @Column(name = "email", nullable = false, length = 45)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "name", nullable = false, length = 45)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "surname", nullable = false, length = 45)
    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Basic
    @Column(name = "mobile_number", nullable = false, length = 45)
    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    @Basic
    @Column(name = "password", nullable = false, length = 45)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "country", nullable = true, length = 45)
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Basic
    @Column(name = "city", nullable = true, length = 45)
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Basic
    @Column(name = "notifications", nullable = true)
    public Integer getNotifications() {
        return notifications;
    }

    public void setNotifications(Integer notifications) {
        this.notifications = notifications;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id &&
                Objects.equals(username, user.username) &&
                Objects.equals(email, user.email) &&
                Objects.equals(name, user.name) &&
                Objects.equals(surname, user.surname) &&
                Objects.equals(mobileNumber, user.mobileNumber) &&
                Objects.equals(password, user.password) &&
                Objects.equals(country, user.country) &&
                Objects.equals(city, user.city) &&
                Objects.equals(notifications, user.notifications);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, username, email, name, surname, mobileNumber, password, country, city, notifications);
    }

    @OneToMany(mappedBy = "user")
    public Collection<Category> getCategoriesById() {
        return categoriesById;
    }

    public void setCategoriesById(Collection<Category> categoriesById) {
        this.categoriesById = categoriesById;
    }

    @OneToMany(mappedBy = "usersByUserOwner")
    public Collection<Contact> getContactsById() {
        return contactsById;
    }

    public void setContactsById(Collection<Contact> contactsById) {
        this.contactsById = contactsById;
    }

    @OneToMany(mappedBy = "usersByContact")
    public Collection<Contact> getContactsById_0() {
        return contactsById_0;
    }

    public void setContactsById_0(Collection<Contact> contactsById_0) {
        this.contactsById_0 = contactsById_0;
    }

    @OneToMany(mappedBy = "usersByUser")
    public Collection<DateNote> getDateNotesById() {
        return dateNotesById;
    }

    public void setDateNotesById(Collection<DateNote> dateNotesById) {
        this.dateNotesById = dateNotesById;
    }

    @OneToMany(mappedBy = "usersByUser")
    public Collection<Event> getEventsById() {
        return eventsById;
    }

    public void setEventsById(Collection<Event> eventsById) {
        this.eventsById = eventsById;
    }

    @OneToMany(mappedBy = "usersByUser")
    public Collection<GroupEventMember> getGroupEventMembersById() {
        return groupEventMembersById;
    }

    public void setGroupEventMembersById(Collection<GroupEventMember> groupEventMembersById) {
        this.groupEventMembersById = groupEventMembersById;
    }

    @OneToMany(mappedBy = "usersByUserOwner")
    public Collection<Permission> getPermissionsById() {
        return permissionsById;
    }

    public void setPermissionsById(Collection<Permission> permissionsById) {
        this.permissionsById = permissionsById;
    }

    @OneToMany(mappedBy = "usersByUserAb")
    public Collection<Permission> getPermissionsById_0() {
        return permissionsById_0;
    }

    public void setPermissionsById_0(Collection<Permission> permissionsById_0) {
        this.permissionsById_0 = permissionsById_0;
    }

    @OneToMany(mappedBy = "usersByUser")
    public Collection<PrivateSetting> getPrivateSettingsById() {
        return privateSettingsById;
    }

    public void setPrivateSettingsById(Collection<PrivateSetting> privateSettingsById) {
        this.privateSettingsById = privateSettingsById;
    }

    @OneToMany(mappedBy = "usersByUser")
    public Collection<Template> getTepmlatesById() {
        return tepmlatesById;
    }

    public void setTepmlatesById(Collection<Template> tepmlatesById) {
        this.tepmlatesById = tepmlatesById;
    }
}
