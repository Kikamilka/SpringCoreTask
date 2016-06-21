package com.epam.spring.core.Dao.Implements;

import com.epam.spring.core.Dao.Interfaces.UserDao;
import com.epam.spring.core.Domain.Ticket;
import com.epam.spring.core.Domain.User;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserDaoImplement implements UserDao {

    private final Map<String, User> users; // id в виде строки,а не числа

    public UserDaoImplement() {
        this.users = new HashMap<>();
    }

    @Override
    public void register(User user) {
        if (user != null && !users.containsKey(user.getId())) {
            users.put(user.getId(), user);
            System.out.println("User was successfully registrated: " + user);
        } else {
            System.out.println("User shouldn't be null");
        }
    }

    @Override
    public void remove(String id) {
        users.remove(id);
    }

    @Override
    public User getById(String id) {
        return users.get(id);
    }

    @Override
    public User getUsersByName(String name) {
        for (Map.Entry<String, User> user : users.entrySet()) {
            if (name.equals(user.getValue().getName())) {
                return user.getValue();
            }
        }
        return null;
    }

    @Override
    public User getUserByEmail(String email) {
        for (Map.Entry<String, User> user : users.entrySet()) {
            if (email.equals(user.getValue().getEmail())) {
                return user.getValue();
            }
        }
        return null;
    }

    @Override
    public List<Ticket> getBookedTickets(String userId) {
        List<Ticket> tickets = Collections.emptyList();
        User user = users.get(userId);
        if (null != user) {
            tickets = user.getTickets();
        }
        return tickets;
    }

}
