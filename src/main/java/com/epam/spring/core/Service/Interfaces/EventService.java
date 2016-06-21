package com.epam.spring.core.Service.Interfaces;

import com.epam.spring.core.Domain.Auditorium;
import com.epam.spring.core.Domain.Event;
import com.epam.spring.core.Domain.RatingEnum;
import java.util.Date;
import java.util.List;

public interface EventService {
    
    Event create(String id, String name, Date airDate, Date airTime, double price, RatingEnum rating);

    void remove(Event event);

    Event getByName(String name);

    List<Event> getAll();

    void assignAuditorium(Event event, Auditorium auditorium, Date date, Date time);
}
