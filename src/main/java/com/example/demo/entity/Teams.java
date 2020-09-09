package com.example.demo.entity;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "teams")
public class Teams {

    @Id
    @Column(nullable = false)
    private int id;

    @Column(nullable = false)
    private String name;

    private String email_domain;

    @Column(nullable = false)
    private int date_create;

    @OneToMany(mappedBy = "teams")
    private List <Users> usersList;

    public int getId ( ) {
        return id;
    }

    public void setId ( int id ) {
        this.id = id;
    }

    public String getName ( ) {
        return name;
    }

    public void setName ( String name ) {
        this.name = name;
    }

    public String getEmail_domain ( ) {
        return email_domain;
    }

    public void setEmail_domain ( String email_domain ) {
        this.email_domain = email_domain;
    }

    public int getDate_create ( ) {
        return date_create;
    }

    public void setDate_create ( int date_create ) {
        this.date_create = date_create;
    }
}
