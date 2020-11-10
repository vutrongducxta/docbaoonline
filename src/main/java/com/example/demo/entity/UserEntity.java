package com.example.demo.entity;

import javax.persistence.*;

import org.springframework.boot.autoconfigure.domain.EntityScan;

@Entity
@Table(name = "user")

public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    @Column(name = "username")
    private String username;
    @Column(name = "password")
    private String password;

    public UserEntity() {
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserEntity(Long id, String username, String password) {
        Id = id;
        this.username = username;
        this.password = password;
    }


}
