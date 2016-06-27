package com.epam.spring.core.services.impls;

import com.epam.spring.core.dao.interfaces.AuditoriumDao;
import com.epam.spring.core.domain.Auditorium;
import com.epam.spring.core.services.interfaces.AuditoriumService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//@Service("auditoriumService")
public class AuditoriumServiceImplement implements AuditoriumService {

    //@Autowired
    private AuditoriumDao auditoriumDao;

    public AuditoriumServiceImplement(AuditoriumDao auditoriumDao) {
        this.auditoriumDao = auditoriumDao;
    }

    public AuditoriumServiceImplement() {
    }

    
    @Override
    public void addAuditorium(Auditorium auditorium) {
        auditoriumDao.add(auditorium);
    }

    @Override
    public List<Auditorium> getAuditoriums() {
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
