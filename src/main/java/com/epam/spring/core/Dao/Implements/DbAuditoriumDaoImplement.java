package com.epam.spring.core.Dao.Implements;

import com.epam.spring.core.Dao.Implements.Mappers.AuditoriumMapper;
import com.epam.spring.core.Dao.Interfaces.AuditoriumDao;
import com.epam.spring.core.Domain.Auditorium;
import java.util.HashSet;
import java.util.Set;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.util.StringUtils;

public class DbAuditoriumDaoImplement implements AuditoriumDao {

    JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void add(Auditorium auditorium) {
        jdbcTemplate.update("INSERT INTO bookingservice.auditorium VALUES (?, ?, ?)",
                null,
                auditorium.getName(),
                auditorium.getSeatsNumber());
        auditorium.setId(jdbcTemplate.queryForObject("SELECT * FROM bookingservice.auditorium "
                + "WHERE name = ?",
                new Object[]{auditorium.getName()},
                new AuditoriumMapper()).getId());
    }

    @Override
    public Set<Auditorium> getAuditoriums() {
        return null;
    }

    @Override
    public int getSeatsNumber(String auditoriumId) {
        return 0;
    }

    @Override
    public String getVipSeats(String auditoriumId) {
        return null;
    }
}
