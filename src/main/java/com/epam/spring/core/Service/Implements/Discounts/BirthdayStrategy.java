package com.epam.spring.core.Service.Implements.Discounts;

import com.epam.spring.core.Domain.User;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.springframework.stereotype.Component;

@Component("birthdayStrategy")
public class BirthdayStrategy implements DiscountStrategy{
    
    private final SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");

    @Override
    public double getDiscount(User user, Date date) {
        double discount = 0;
        if (dateFormat.format(date).equals(user.getBirthday())) {
            discount = 0.05;
            System.out.println("User '" + user.getName() + "' had got 5% discount by Birthday Strategy");
        }
        return discount;
    }
    
}
