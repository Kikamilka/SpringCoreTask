package com.epam.spring.core.services.impls.discounts;

import com.epam.spring.core.domain.Ticket;
import com.epam.spring.core.domain.User;
import java.util.Date;
import java.util.List;

public class EveryTenthStrategy implements DiscountStrategy{
    
    private final double DISCOUNT_TENTH = 0.5;
    
    @Override
    public double getDiscount(User user, Date date) {
        double discount = 0;
        List<Ticket> purchesedTickets = user.getTickets();
        if (user.getTickets() != null && !purchesedTickets.isEmpty() && purchesedTickets.size()%10 == 0 ) {
            discount = DISCOUNT_TENTH;
            System.out.println("User ' " + user.getName() + "' has got 50% discount by Every 10th Tiket Strategy");
        }
        return discount;
    }
}
