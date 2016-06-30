package com.epam.spring.core.services.interfaces;

import com.epam.spring.core.domain.Event;
import com.epam.spring.core.domain.Ticket;
import com.epam.spring.core.domain.User;
import java.util.Date;
import java.util.List;

public interface BookingService {
    
    double getTicketPrice(Event event, Date date, Date time, int seats, User user);

    void bookTicket(User user, Ticket ticket);

    List<Ticket> getTicketsForEvent(Event event, Date date);
}
