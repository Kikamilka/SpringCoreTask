package com.epam.spring.core.Dao.Implements;

import com.epam.spring.core.Dao.Interfaces.EventDao;
import com.epam.spring.core.Domain.Auditorium;
import com.epam.spring.core.Domain.Event;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;

@Repository("eventDao")
public class EventDaoImplement implements EventDao {

    private final Map<String, Event> events = new HashMap<>();

    @Override
    public void create(Event event) {
        events.put(event.getId(), event);
    }

    @Override
    public void remove(String id) {
        events.remove(id);
    }

    @Override
    public Event getByName(String name) {
        Event event = null;
        for (Map.Entry<String, Event> eventEntry : events.entrySet()) {
            if (name.equals(eventEntry.getValue().getName())) {
                event = eventEntry.getValue();
            }
        }
        return event;
    }

    @Override
    public List<Event> getAll() {
        return new ArrayList(events.values());
    }

    @Override
    public void assignAuditorium(String eventId, Auditorium auditorium, String date, String time) {
        Event event = events.get(eventId);
        if (null != event) {
            event.setAuditorium(auditorium);
            event.setAirDate(date);
            event.setAirTime(time);
        }
    }

}
