package com.epam.spring.core.domain;

public class Ticket {

    private String price;
    private String seat;
    private String nameEvent;

    public Ticket() {
    }

    
    public Ticket(String price, String seat, String nameEvent) {
        this.price = price;
        this.seat = seat;
        this.nameEvent = nameEvent;
    }

    public String getSeat() {
        return seat;
    }

    public void setSeat(String seat) {
        this.seat = seat;
    }

    public String getNameEvent() {
        return nameEvent;
    }

    public void setNameEvent(String nameEvent) {
        this.nameEvent = nameEvent;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Ticket [seat=" + seat + ", nameEvent=" + nameEvent + ", price="
                + price + "]";
    }

}
