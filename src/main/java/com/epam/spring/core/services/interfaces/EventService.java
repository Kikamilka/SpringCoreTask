package com.epam.spring.core.services.interfaces;

import com.epam.spring.core.domain.Event;
import com.epam.spring.core.domain.RatingEnum;
import java.util.Date;
import java.util.List;

public interface EventService {
    
    Event create(String id, String name, Date airDate, Date airTime, double price, RatingEnum rating);

    void remove(Event event);

    Event getByName(String name);

    List<Event> getAll();

    void assignAuditorium(Event event, String auditorium, Date date, Date time);
}
