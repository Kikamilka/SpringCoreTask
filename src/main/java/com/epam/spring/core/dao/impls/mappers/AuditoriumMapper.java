package com.epam.spring.core.dao.impls.mappers;

import com.epam.spring.core.domain.Auditorium;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class AuditoriumMapper implements RowMapper<Auditorium> {

    @Override
    public Auditorium mapRow(ResultSet resultSet, int i) throws SQLException {
        return new Auditorium(
                resultSet.getString("id"),
                resultSet.getString("name"),
                resultSet.getInt("seatsNumber"),
                resultSet.getString("vipSeats"));
    }
}
