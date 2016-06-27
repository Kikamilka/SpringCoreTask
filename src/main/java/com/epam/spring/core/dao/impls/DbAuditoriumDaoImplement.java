package com.epam.spring.core.dao.impls;

import com.epam.spring.core.dao.impls.mappers.AuditoriumMapper;
import com.epam.spring.core.dao.interfaces.AuditoriumDao;
import com.epam.spring.core.domain.Auditorium;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

public class DbAuditoriumDaoImplement implements AuditoriumDao {

    JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void add(Auditorium auditorium) {
        jdbcTemplate.update("INSERT INTO bookingservice.auditorium VALUES (?, ?, ?, ?)",
                null,
                auditorium.getName(),
                auditorium.getSeatsNumber(),
                auditorium.getVipSeats());
        auditorium.setId(jdbcTemplate.queryForObject("SELECT * FROM bookingservice.auditorium "
                + "WHERE name = ?",
                new Object[]{auditorium.getName()},
                new AuditoriumMapper()).getId());
    }

    @Override
    public List<Auditorium> getAuditoriums() {
        return jdbcTemplate.query("SELECT * FROM bookingservice.auditorium ",
                new AuditoriumMapper());
    }

    @Override
    public int getSeatsNumber(String auditoriumId) {
        return jdbcTemplate.queryForObject("SELECT * FROM bookingservice.auditorium "
                + "WHERE id = ?",
                new Object[]{auditoriumId},
                new AuditoriumMapper()).getSeatsNumber();
    }

    @Override
    public String getVipSeats(String auditoriumId) {
        return jdbcTemplate.queryForObject("SELECT * FROM bookingservice.auditorium " +
                        "WHERE idAuditorium = ?",
                new Object[] {auditoriumId},
                new AuditoriumMapper()).getVipSeats();
    }
}
