package com.epam.spring.core.Service.Interfaces;

import com.epam.spring.core.Domain.Event;
import com.epam.spring.core.Domain.User;
import java.util.Date;

public interface DiscountService {
    
    double getDiscount(User user, Event event, Date date);
    
}
