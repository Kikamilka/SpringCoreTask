package com.epam.spring.core.dao.interfaces;

import com.epam.spring.core.domain.Event;
import java.util.List;

public interface EventDao {
    
    void create(Event event);

    void remove(String id);

    Event getByName(String name);

    List<Event> getAll();

    void assignAuditorium(String eventId, String auditorium, String date, String time);
}
