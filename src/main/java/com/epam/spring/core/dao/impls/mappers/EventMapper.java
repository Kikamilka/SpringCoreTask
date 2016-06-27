package com.epam.spring.core.dao.impls.mappers;

import com.epam.spring.core.domain.Event;
import com.epam.spring.core.domain.RatingEnum;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class EventMapper implements RowMapper<Event> {

    @Override
    public Event mapRow(ResultSet resultSet, int i) throws SQLException {
        return new Event(
                resultSet.getString("id"),
                resultSet.getString("name"),
                resultSet.getString("airDate"),
                resultSet.getString("airTime"),
                resultSet.getDouble("price"),
                RatingEnum.valueOf(resultSet.getString("rating")), 
                resultSet.getString("auditorium"));
    }
}
