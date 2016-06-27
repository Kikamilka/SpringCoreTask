package com.epam.spring.core.dao.impls;

import com.epam.spring.core.dao.interfaces.AuditoriumDao;
import com.epam.spring.core.domain.Auditorium;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.util.StringUtils;

public class AuditoriumDaoImplement implements AuditoriumDao {

    private final Map<String, Auditorium> auditoriums = new HashMap<>();

    @Override
    public void add(Auditorium auditorium) {
        if (null != auditorium.getId() && !auditoriums.containsKey(auditorium.getId())) {
            auditoriums.put(auditorium.getId(), auditorium);
            System.out.println("Auditorium was successfully added: " + auditorium);
        } else {
            System.out.println("Auditorium's id shouldn't be null");
        }
    }

    @Override
    public List<Auditorium> getAuditoriums() {
        return new ArrayList<>(auditoriums.values());
    }

    @Override
    public int getSeatsNumber(String auditoriumId) {
        return !StringUtils.isEmpty(auditoriumId)
                ? auditoriums.get(auditoriumId).getSeatsNumber() : 0;
    }

    @Override
    public String getVipSeats(String auditoriumId) {
        String vipSeats = "";
        if (!StringUtils.isEmpty(auditoriumId)) {
            vipSeats = auditoriums.get(auditoriumId).getVipSeats();
        }
        return vipSeats;
    }

}
