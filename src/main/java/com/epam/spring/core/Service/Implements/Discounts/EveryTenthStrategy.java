package com.epam.spring.core.Service.Implements.Discounts;

import com.epam.spring.core.Domain.Ticket;
import com.epam.spring.core.Domain.User;
import java.util.Date;
import java.util.List;
import org.springframework.stereotype.Component;

@Component("everyTenthTicket")
public class EveryTenthStrategy implements DiscountStrategy{
    
    @Override
    public double getDiscount(User user, Date date) {
        double discount = 0;
        List<Ticket> purchesedTickets = user.getTickets();
        if (user.getTickets() != null && !purchesedTickets.isEmpty() && purchesedTickets.size()%10 == 0 ) {
            discount = 0.5;
            System.out.println("User ' " + user.getName() + "' has got 50% discount by Every 10th Tiket Strategy");
        }
        return discount;
    }
}
