package com.epam.spring.core.dao.impls;

import com.epam.spring.core.dao.impls.exeptions.DaoDbExeption;
import com.epam.spring.core.dao.impls.mappers.EventMapper;
import com.epam.spring.core.dao.interfaces.EventDao;
import com.epam.spring.core.domain.Event;
import java.util.List;
import java.util.logging.Level;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

public class DbEventDaoImplement implements EventDao {

    private JdbcTemplate jdbcTemplate;

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
        try {
            return jdbcTemplate.queryForObject("SELECT * FROM bookingservice.event "
                    + "WHERE name = ?",
                    new Object[]{name},
                    new EventMapper());
        } catch (DataAccessException ex) {
            System.out.println("Event with name: " + name + "does'n exist");
            try {                
                throw new DaoDbExeption(ex.getMessage());
            } catch (DaoDbExeption ex1) {
                java.util.logging.Logger.getLogger(DbAuditoriumDaoImplement.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
        return null;
    }

    @Override
    public List<Event> getAll() {
        try {
            return jdbcTemplate.query("SELECT * FROM bookingservice.event ",
                    new EventMapper());
        } catch (DataAccessException ex) {
            System.out.println("Events list does'n exist");
            try {                
                throw new DaoDbExeption(ex.getMessage());
            } catch (DaoDbExeption ex1) {
                java.util.logging.Logger.getLogger(DbAuditoriumDaoImplement.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
        return null;
    }

    @Override
    public void assignAuditorium(String eventId, String auditorium, String date, String time) {
        try {
            Event event = jdbcTemplate.queryForObject("SELECT * FROM bookingservice.event "
                    + "WHERE id = ?",
                    new Object[]{eventId},
                    new EventMapper());
            event.setAuditorium(auditorium);
            event.setAirDate(date);
            event.setAirTime(time);
        } catch (DataAccessException ex) {
            System.out.println("Event with id: " + eventId + "does'n exist");
            try {                
                throw new DaoDbExeption(ex.getMessage());
            } catch (DaoDbExeption ex1) {
                java.util.logging.Logger.getLogger(DbAuditoriumDaoImplement.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
    }
}
