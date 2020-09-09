package com.example.demo.entity;

import javax.persistence.*;

@Entity
@Table (name = "users")
public class Users {

    @Id
    @Column(nullable = false)
    private int id;

    @ManyToOne
    @JoinColumn(name = "team_id")
    private Teams teams;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private int deleted;

    public int getId ( ) {
        return id;
    }

    public void setId ( int id ) {
        this.id = id;
    }

    public String getEmail ( ) {
        return email;
    }

    public void setEmail ( String email ) {
        this.email = email;
    }

    public String getUsername ( ) {
        return username;
    }

    public void setUsername ( String username ) {
        this.username = username;
    }

    public int getDeleted ( ) {
        return deleted;
    }

    public void setDeleted ( int deleted ) {
        this.deleted = deleted;
    }
}
