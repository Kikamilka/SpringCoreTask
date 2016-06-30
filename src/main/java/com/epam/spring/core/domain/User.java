package com.epam.spring.core.domain;

import java.util.List;

public class User {

    private String id;
    private String name;
    private String birthday;
    private String email;
    private List<Ticket> tickets;

    @Override
    public String toString() {
        return "User [id=" + id + ", name=" + name + ", birthday="
                + birthday + ", email=" + email
                + "]";
    }

    public User() {
    }

    
    public User(String id, String name, String birthday, String email) {
        this.id = id;
        this.name = name;
        this.birthday = birthday;
        this.email = email;
    }
    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getBirthday() {
        return birthday;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(List<Ticket> tikets) {
        this.tickets = tikets;
    }

}
