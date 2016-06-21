package com.epam.spring.core.Dao.Interfaces;

import com.epam.spring.core.Domain.Auditorium;
import java.util.Set;

public interface AuditoriumDao {
    
    void add(Auditorium auditorium);

    Set<Auditorium> getAuditoriums();

    int getSeatsNumber(String auditoriumId);

    String getVipSeats(String auditoriumId);
}
