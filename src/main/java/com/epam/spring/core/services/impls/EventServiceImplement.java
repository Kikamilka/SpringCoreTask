package com.epam.spring.core.services.impls;

import com.epam.spring.core.dao.interfaces.EventDao;
import com.epam.spring.core.domain.Auditorium;
import com.epam.spring.core.domain.Event;
import com.epam.spring.core.domain.RatingEnum;
import com.epam.spring.core.services.interfaces.EventService;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

//@Service("eventService")
public class EventServiceImplement implements EventService {

    //@Autowired
    private EventDao eventDao;

    private final Map<String, Event> events = new HashMap<>();
    private final SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy"); // 04.07.1990 <- dd.MM.yyyy
    private final SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");

    public EventServiceImplement() {
    }

    public EventServiceImplement(EventDao eventDao) {
        this.eventDao = eventDao;
    }

    @Override
    public Event create(String id, String name, Date airDate, Date airTime, double price, RatingEnum rating) {
        Event event = new Event(id, name, dateFormat.format(airDate), timeFormat.format(airTime), price, rating, null);
        eventDao.create(event);
        return event;
    }

    @Override
    public void remove(Event event) {
        events.remove(event.getId());
    }

    @Override
    public Event getByName(String name) {
        return !StringUtils.isEmpty(name) ? eventDao.getByName(name) : null;
    }

    @Override
    public List<Event> getAll() {
        return new ArrayList(events.values());
    }

    @Override
    public void assignAuditorium(Event event, String auditorium, Date date, Date time) {
        if (event != null && auditorium != null) {
            eventDao.assignAuditorium(event.getId(), auditorium, dateFormat.format(date), timeFormat.format(time));
        } else {
            System.out.println("Event/Auditorium shouldn't be null");
        }
    }

}
