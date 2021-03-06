package com.epam.spring.core.Dao.Implements;

import com.epam.spring.core.Dao.Interfaces.AuditoriumDao;
import com.epam.spring.core.Domain.Auditorium;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

@Repository("auditoriumDao")
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
    public Set<Auditorium> getAuditoriums() {
        return new HashSet<>(auditoriums.values());
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
