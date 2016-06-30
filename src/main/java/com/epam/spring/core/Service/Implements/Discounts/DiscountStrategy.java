package com.epam.spring.core.Service.Implements.Discounts;

import com.epam.spring.core.Domain.User;
import java.util.Date;

public interface DiscountStrategy {
    
    public double getDiscount(User user, Date date);
}
