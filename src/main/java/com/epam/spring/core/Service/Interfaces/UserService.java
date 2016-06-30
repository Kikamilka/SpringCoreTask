package com.epam.spring.core.Service.Interfaces;

import com.epam.spring.core.Domain.Ticket;
import com.epam.spring.core.Domain.User;
import java.util.List;

public interface UserService {

    void register(User user);

    void remove(User user);

    User getById(String id);

    User getUsersByName(String name);

    User getUserByEmail(String email);

    List<Ticket> getBookedTickets(User user);

}
