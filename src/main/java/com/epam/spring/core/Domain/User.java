package com.epam.spring.core.Domain;

import java.util.List;

public class User {

    private final String id;
    private String name;
    private String dayOfBirth;
    private String email;
    private List<Ticket> tickets;

    @Override
    public String toString() {
        return "User [id=" + id + ", name=" + name + ", dayOfBirth="
                + dayOfBirth + ", email=" + email
                + "]";
    }

    public User(String id, String name, String dayOfBirth, String email) {        
        // 04.07.1990 <- dd.MM.yyyy
        //DateFormat format = new SimpleDateFormat("dd.MM.yyyy", Locale.ENGLISH);
        //this.dayOfBirth = format.parse(dayOfBirth);
        this.id = id;
        this.name = name;
        this.dayOfBirth = dayOfBirth;        
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

    public void setDayOfBirth(String dayOfBirth) {
        this.dayOfBirth = dayOfBirth;
    }

    public String getDayOfBirth() {
        return dayOfBirth;
    }

    public String getId() {
        return id;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(List<Ticket> tikets) {
        this.tickets = tikets;
    }

}
