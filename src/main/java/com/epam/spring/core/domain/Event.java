package com.epam.spring.core.domain;

public class Event {
    
    private String id;
    private String name;
    private String airDate;
    private String airTime;
    private double price;
    private RatingEnum rating;
    private String auditorium;

    public Event() {
    }

    
    public Event(String id, String name, String airDate, String airTime, double price, RatingEnum rating, String auditorium) {
        this.id = id;
        this.name = name;
        this.airDate = airDate;
        this.airTime = airTime;
        this.price = price;
        this.rating = rating;
        this.auditorium = auditorium;
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public RatingEnum getRating() {
        return rating;
    }

    public void setRating(RatingEnum rating) {
        this.rating = rating;
    }

    public String getAuditorium() {
        return auditorium;
    }

    public void setAuditorium(String auditorium) {
        this.auditorium = auditorium;
    }

    public String getAirDate() {
        return airDate;
    }

    public void setAirDate(String airDate) {
        this.airDate = airDate;
    }

    public String getAirTime() {
        return airTime;
    }

    public void setAirTime(String airTime) {
        this.airTime = airTime;
    }

    @Override
    public String toString() {
        return "Event [id=" + id + ", name=" + name + ", airDate="
                + airDate + ", airTime=" + airTime + ", price=" + price
                + ", rating=" + rating + ", auditorium=" + auditorium
                + "]";
    }
    
}
