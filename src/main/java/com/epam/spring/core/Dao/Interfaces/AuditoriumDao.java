package com.epam.spring.core.dao.interfaces;

import com.epam.spring.core.domain.Auditorium;
import java.util.Set;

public interface AuditoriumDao {
    
    void add(Auditorium auditorium);

    Set<Auditorium> getAuditoriums();

    int getSeatsNumber(String auditoriumId);

    String getVipSeats(String auditoriumId);
}
