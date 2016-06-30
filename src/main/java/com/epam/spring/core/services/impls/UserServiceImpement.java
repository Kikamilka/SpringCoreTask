package com.epam.spring.core.services.impls;

import com.epam.spring.core.dao.interfaces.UserDao;
import com.epam.spring.core.domain.Ticket;
import com.epam.spring.core.domain.User;
import com.epam.spring.core.services.interfaces.UserService;
import java.util.Collections;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

//@Service("userService")
public class UserServiceImpement implements UserService {

    //@Autowired
    private UserDao userDao;

    @Override
    public void register(User user) {
        if (null != user) {
            userDao.register(user);
        } else {
            System.out.println("User should't be null");
        }
    }

    public UserServiceImpement() {
    }

    public UserServiceImpement(UserDao userDao) {
        this.userDao = userDao;
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
