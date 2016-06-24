package com.epam.spring.core.dao.impls.mappers;

import com.epam.spring.core.domain.Ticket;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class TicketMapper implements RowMapper<Ticket> {
    @Override
    public Ticket mapRow(ResultSet resultSet, int i) throws SQLException {
        return new Ticket(
                resultSet.getString("price"),
                resultSet.getString("seat"),
                resultSet.getString("nameevent"));

    }
}
