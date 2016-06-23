package com.epam.spring.core.Dao.Interfaces;

import com.epam.spring.core.Domain.Ticket;
import com.epam.spring.core.Domain.User;
import java.util.List;

public interface UserDao {

    void register(User user);

    void remove(String id);

    User getById(String id);

    User getUsersByName(String name);

    User getUserByEmail(String email);

    List<Ticket> getBookedTickets(String userId);
    
    List<User> getAll();
}
