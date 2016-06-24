package com.epam.spring.core.services.interfaces;

import com.epam.spring.core.domain.Auditorium;
import java.util.Set;

public interface AuditoriumService {
    
    void addAuditorium(Auditorium auditorium);
    
    Set<Auditorium> getAuditoriums();
    
    int getSeatsNumber(Auditorium auditorium);
    
    String getVipSeats(Auditorium auditorium);
}
