package com.epam.spring.core.dao.impls;

import com.epam.spring.core.dao.impls.exeptions.DaoDbExeption;
import com.epam.spring.core.dao.impls.mappers.TicketMapper;
import com.epam.spring.core.dao.impls.mappers.UserMapper;
import com.epam.spring.core.dao.interfaces.UserDao;
import com.epam.spring.core.domain.Ticket;
import com.epam.spring.core.domain.User;
import java.util.List;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

public class DbUserDaoImplement implements UserDao {

    private JdbcTemplate jdbcTemplate;

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
        try {
            user.setId(jdbcTemplate.queryForObject("SELECT * FROM bookingservice.user "
                    + "WHERE email = ?",
                    new Object[]{user.getEmail()},
                    new UserMapper()).getId());
        } catch (DataAccessException ex) {
            System.out.println("Error message" + ex.getMessage());
            throw new DaoDbExeption(ex);
        }
    }

    @Override
    public void remove(String id) {
        jdbcTemplate.update("DELETE FROM bookingservice.user "
                + "WHERE id = ?",
                id);
    }

    @Override
    public User getById(String id) {
        try {
            return jdbcTemplate.queryForObject("SELECT * FROM bookingservice.user "
                    + "WHERE id = ?",
                    new Object[]{id},
                    new UserMapper());
        } catch (DataAccessException ex) {
            System.out.println("Error message" + ex.getMessage());
            throw new DaoDbExeption(ex);
        }
    }

    @Override
    public User getUsersByName(String name) {
        try {
            return jdbcTemplate.queryForObject("SELECT * FROM bookingservice.user "
                    + "WHERE name = ?",
                    new Object[]{name},
                    new UserMapper());
        } catch (DataAccessException ex) {
            System.out.println("Error message" + ex.getMessage());
            throw new DaoDbExeption(ex);
        }
    }

    @Override
    public User getUserByEmail(String email) {
        try {
            return jdbcTemplate.queryForObject("SELECT * FROM bookingservice.user "
                    + "WHERE email = ?",
                    new Object[]{email},
                    new UserMapper());
        } catch (DataAccessException ex) {
            System.out.println("Error message" + ex.getMessage());
            throw new DaoDbExeption(ex);
        }
    }

    @Override
    public List<Ticket> getBookedTickets(String userId) {
        try {
            return jdbcTemplate.query("SELECT * FROM bookingservice.bookedticket "
                    + "WHERE idUser = ?",
                    new Object[]{userId},
                    new TicketMapper());
        } catch (DataAccessException ex) {
            System.out.println("Error message" + ex.getMessage());
            throw new DaoDbExeption(ex);
        }
    }

    @Override
    public List<User> getAll() {
        try {
            return jdbcTemplate.query("SELECT * FROM bookingservice.user ",
                    new UserMapper());
        } catch (DataAccessException ex) {
            System.out.println("Error message" + ex.getMessage());
            throw new DaoDbExeption(ex);
        }
    }

}
