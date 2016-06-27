package com.epam.spring.core.dao.impls;

import com.epam.spring.core.dao.impls.mappers.EventMapper;
import com.epam.spring.core.dao.interfaces.EventDao;
import com.epam.spring.core.domain.Event;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

public class DbEventDaoImplement implements EventDao {

    JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void create(Event event) {
        jdbcTemplate.update("INSERT INTO bookingservice.event VALUES (?, ?, ?, ?, ?, ?, ?)",
                event.getId(),
                event.getName(),
                event.getAirDate(),
                event.getAirTime(),
                event.getPrice(),
                event.getRating(),
                event.getAuditorium());
    }

    @Override
    public void remove(String id) {
        jdbcTemplate.update("DELETE FROM bookingservice.event "
                + "WHERE id = ?",
                id);
    }

    @Override
    public Event getByName(String name) {
        return jdbcTemplate.queryForObject("SELECT * FROM bookingservice.event "
                + "WHERE name = ?",
                new Object[] {name}, 
                new EventMapper());
    }

    @Override
    public List<Event> getAll() {
        return jdbcTemplate.query("SELECT * FROM bookingservice.event ",
                new EventMapper());
    }

    @Override
    public void assignAuditorium(String eventId, String auditorium, String date, String time) {
        Event event = jdbcTemplate.queryForObject("SELECT * FROM bookingservice.event "
                + "WHERE id = ?",
                new Object[] {eventId},
                new EventMapper());
        event.setAuditorium(auditorium);
        event.setAirDate(date);
        event.setAirTime(time);
    }
}
