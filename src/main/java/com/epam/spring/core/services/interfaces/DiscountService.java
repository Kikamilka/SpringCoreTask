package com.epam.spring.core.services.interfaces;

import com.epam.spring.core.domain.Event;
import com.epam.spring.core.domain.User;
import java.util.Date;

public interface DiscountService {
    
    double getDiscount(User user, Event event, Date date);
    
}
