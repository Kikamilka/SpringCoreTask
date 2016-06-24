package com.epam.spring.core.services.impls;

import com.epam.spring.core.dao.interfaces.AuditoriumDao;
import com.epam.spring.core.domain.Auditorium;
import com.epam.spring.core.services.interfaces.AuditoriumService;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("auditoriumService")
public class AuditoriumServiceImplement implements AuditoriumService {

    @Autowired
    private AuditoriumDao auditoriumDao;

    public void addAuditorium(Auditorium auditorium) {
        auditoriumDao.add(auditorium);
    }

    @Override
    public Set<Auditorium> getAuditoriums() {
        return auditoriumDao.getAuditoriums();
    }

    public int getSeatsNumber(Auditorium auditorium) {
        return auditoriumDao.getSeatsNumber(auditorium.getId());
    }

    public String getVipSeats(Auditorium auditorium) {
        return auditoriumDao.getVipSeats(auditorium.getId());
    }

}
