package com.epam.spring.core.Service.Implements;

import com.epam.spring.core.Dao.Interfaces.UserDao;
import com.epam.spring.core.Domain.Ticket;
import com.epam.spring.core.Domain.User;
import com.epam.spring.core.Service.Interfaces.UserService;
import java.util.Collections;
import java.util.List;
import org.springframework.util.StringUtils;

public class UserServiceImpement implements UserService{

    private UserDao userDao;
    
    @Override
    public void register(User user) {
        if (null != user) {
            userDao.register(user);
        } else {
            System.out.println("User should't be null");
        }
    }

    @Override
    public void remove(User user) {
        if (null != user && null != user.getId()) {
            userDao.remove(user.getId());
        } else {
            System.out.println("User or user's id shouldn't be null");
        }
    }

    @Override
    public User getById(String id) {
        return !StringUtils.isEmpty(id) ? userDao.getById(id) : null;
    }

    @Override
    public User getUsersByName(String name) {
        return !StringUtils.isEmpty(name) ? userDao.getUsersByName(name) : null;
    }

    @Override
    public User getUserByEmail(String email) {
        return !StringUtils.isEmpty(email) ? userDao.getUserByEmail(email) : null;
    }

    @Override
    public List<Ticket> getBookedTickets(User user) {
        return null != user && null != user.getId()
            ? userDao.getBookedTickets(user.getId())
            : Collections.<Ticket>emptyList();
    }
    
}
