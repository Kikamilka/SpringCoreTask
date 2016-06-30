package com.epam.spring.core.Dao.Interfaces;

import com.epam.spring.core.Domain.Auditorium;
import com.epam.spring.core.Domain.Event;
import java.util.List;

public interface EventDao {
    
    void create(Event event);

    void remove(String id);

    Event getByName(String name);

    List<Event> getAll();

    void assignAuditorium(String eventId, Auditorium auditorium, String date, String time);
}
