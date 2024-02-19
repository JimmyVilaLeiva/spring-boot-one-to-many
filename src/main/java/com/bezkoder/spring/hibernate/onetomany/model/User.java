package com.bezkoder.spring.hibernate.onetomany.model;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="user_id")
    private long userId;

    @Column(name="first_name", nullable=false, length=50)
    private String firstname;

    @Column(name="last_name", length=20)
    private String lastname;

    public User() {

    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public User(String firstname, String lastname) {
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }


}
