package com.epam.spring.core.services.impls.discounts;

import com.epam.spring.core.domain.User;
import java.util.Date;

public interface DiscountStrategy {
    
    public double getDiscount(User user, Date date);
}
