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
        String day = dateFormat.format(date).substring(0, 2);
        String month = dateFormat.format(date).substring(3, 5);
        if (day.equals(user.getBirthday().substring(0, 2)) && month.equals(user.getBirthday().substring(3, 5))) {
            discount = 0.05;
            System.out.println("User '" + user.getName() + "' had got 5% discount by Birthday Strategy");
        }
        return discount;
    }
    
}
