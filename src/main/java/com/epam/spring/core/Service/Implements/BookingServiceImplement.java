package com.epam.spring.core.Service.Implements;

import com.epam.spring.core.Dao.Interfaces.BookingDao;
import com.epam.spring.core.Domain.Event;
import com.epam.spring.core.Domain.Ticket;
import com.epam.spring.core.Domain.User;
import com.epam.spring.core.Service.Interfaces.BookingService;
import com.epam.spring.core.Service.Interfaces.DiscountService;
import com.epam.spring.core.Service.Interfaces.EventService;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("bookingService")
public class BookingServiceImplement implements BookingService {
    
    @Autowired
    private EventService eventService;
    
    @Autowired
    private DiscountService discountService;

    private final Map<User, List<Ticket>> bookedTickets = new HashMap<>();

    @Override
    public double getTicketPrice(Event event, Date date, Date time, int seats, User user) {
        double price = 0;
        if (null != eventService.getByName(event.getName())) {
            double dicount = discountService.getDiscount(user, event, date);
            price = event.getPrice() - event.getPrice() * dicount;
        }
        return price;
    }

    @Override
    public void bookTicket(User user, Ticket ticket) {
        List<Ticket> userTickets = user.getTickets();
        userTickets.add(ticket);
        bookedTickets.put(user, bookedTickets.put(user, userTickets));
    }

    @Override
    public List<Ticket> getTicketsForEvent(Event event, Date date) {
        return Collections.emptyList();
    }

}
