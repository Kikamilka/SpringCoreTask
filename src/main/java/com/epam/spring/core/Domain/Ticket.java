package com.epam.spring.core.Domain;

public class Ticket {

    private double price;
    private String seat;
    private boolean isBuyed;

    public Ticket(double price, String seat, boolean isBuyed) {
        this.price = price;
        this.seat = seat;
        this.isBuyed = isBuyed;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getSeat() {
        return seat;
    }

    public void setSeat(String seat) {
        this.seat = seat;
    }

    public void setIsBuyed(boolean isBuyed) {
        this.isBuyed = isBuyed;
    }

    @Override
    public String toString() {
        return "Ticket [price=" + price + ", seat=" + seat + ", isBuyed="
                + isBuyed + "]";
    }

}
