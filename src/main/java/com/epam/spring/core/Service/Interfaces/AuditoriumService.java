package com.epam.spring.core.Service.Interfaces;

import com.epam.spring.core.Domain.Auditorium;
import java.util.Set;

public interface AuditoriumService {
    
    void addAuditorium(Auditorium auditorium);
    
    Set<Auditorium> getAuditoriums();
    
    int getSeatsNumber(Auditorium auditorium);
    
    String getVipSeats(Auditorium auditorium);
}
