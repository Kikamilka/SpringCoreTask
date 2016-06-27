package com.epam.spring.core.dao.impls;

import com.epam.spring.core.dao.impls.mappers.TicketMapper;
import com.epam.spring.core.dao.impls.mappers.UserMapper;
import com.epam.spring.core.dao.interfaces.UserDao;
import com.epam.spring.core.domain.Ticket;
import com.epam.spring.core.domain.User;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

public class DbUserDaoImplement implements UserDao {

    JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void register(User user) {
        jdbcTemplate.update("INSERT INTO bookingservice.user VALUES (?, ?, ?, ?)",
                null,
                user.getName(),
                user.getEmail(),
                user.getBirthday());
        user.setId(jdbcTemplate.queryForObject("SELECT * FROM bookingservice.user "
                + "WHERE email = ?",
                new Object[]{user.getEmail()},
                new UserMapper()).getId());
    }

    @Override
    public void remove(String id) {
        jdbcTemplate.update("DELETE FROM bookingservice.user "
                + "WHERE id = ?",
                id);
    }

    @Override
    public User getById(String id) {
        return jdbcTemplate.queryForObject("SELECT * FROM bookingservice.user "
                + "WHERE id = ?",
                new Object[]{id},
                new UserMapper());
    }

    @Override
    public User getUsersByName(String name) {
        return jdbcTemplate.queryForObject("SELECT * FROM bookingservice.user "
                + "WHERE name = ?",
                new Object[]{name},
                new UserMapper());
    }

    @Override
    public User getUserByEmail(String email) {
        return jdbcTemplate.queryForObject("SELECT * FROM bookingservice.user "
                + "WHERE email = ?",
                new Object[]{email},
                new UserMapper());
    }

    @Override
    public List<Ticket> getBookedTickets(String userId) {
        return jdbcTemplate.query("SELECT * FROM bookingservice.bookedticket "
                + "WHERE idUser = ?",
                new Object[]{userId},
                new TicketMapper());
    }

    @Override
    public List<User> getAll() {
        return jdbcTemplate.query("SELECT * FROM bookingservice.user ",
                new UserMapper());
    }

}
