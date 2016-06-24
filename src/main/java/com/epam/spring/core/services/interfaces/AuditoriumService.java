package com.epam.spring.core.services.interfaces;

import com.epam.spring.core.domain.Auditorium;
import java.util.List;

public interface AuditoriumService {
    
    void addAuditorium(Auditorium auditorium);
    
    List<Auditorium> getAuditoriums();
    
    int getSeatsNumber(Auditorium auditorium);
    
    String getVipSeats(Auditorium auditorium);
}
