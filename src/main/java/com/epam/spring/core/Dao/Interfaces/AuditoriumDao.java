package com.epam.spring.core.dao.interfaces;

import com.epam.spring.core.domain.Auditorium;
import java.util.List;

public interface AuditoriumDao {
    
    void add(Auditorium auditorium);

    List<Auditorium> getAuditoriums();

    int getSeatsNumber(String auditoriumId);

    String getVipSeats(String auditoriumId);
}
