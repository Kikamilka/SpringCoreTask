package com.epam.spring.core.Service.Implements;

import com.epam.spring.core.Dao.Interfaces.AuditoriumDao;
import com.epam.spring.core.Domain.Auditorium;
import com.epam.spring.core.Service.Interfaces.AuditoriumService;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("auditoriumService")
public class AuditoriumServiceImplement implements AuditoriumService {

    @Autowired
    private AuditoriumDao auditoriumDao;

    @Override
    public void addAuditorium(Auditorium auditorium) {
        auditoriumDao.add(auditorium);
    }

    @Override
    public Set<Auditorium> getAuditoriums() {
        return auditoriumDao.getAuditoriums();
    }

    @Override
    public int getSeatsNumber(Auditorium auditorium) {
        return auditoriumDao.getSeatsNumber(auditorium.getId());
    }

    @Override
    public String getVipSeats(Auditorium auditorium) {
        return auditoriumDao.getVipSeats(auditorium.getId());
    }
}
