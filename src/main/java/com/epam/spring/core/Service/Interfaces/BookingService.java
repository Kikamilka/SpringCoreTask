package com.epam.spring.core.Service.Interfaces;

import com.epam.spring.core.Domain.Event;
import com.epam.spring.core.Domain.Ticket;
import com.epam.spring.core.Domain.User;
import java.util.Date;
import java.util.List;

public interface BookingService {
    
    double getTicketPrice(Event event, Date date, Date time, int seats, User user);

    void bookTicket(User user, Ticket ticket);

    List<Ticket> getTicketsForEvent(Event event, Date date);
}
