package com.epam.spring.core.domain;

public class Auditorium {
    
    private String id;
    private String name;
    private int seatsNumber;
    private String vipSeats;

    public Auditorium() {
    }

    public Auditorium(String id, String name, int seatsNumber, String vipSeats) {
        this.id = id;
        this.name = name;
        this.seatsNumber = seatsNumber;
        this.vipSeats = vipSeats;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSeatsNumber() {
        return seatsNumber;
    }

    public void setSeatsNumber(int seatsNumber) {
        this.seatsNumber = seatsNumber;
    }

    public String getVipSeats() {
        return vipSeats;
    }

    public void setVipSeats(String vipSeats) {
        this.vipSeats = vipSeats;
    }

    @Override
    public String toString() {
        return "Auditorium [id=" + id + ", name=" + name + ", seatsNumber="
                + seatsNumber + ", vipSeats=" + vipSeats
                + "]";
    }
    
}
