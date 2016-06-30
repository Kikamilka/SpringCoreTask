package com.epam.spring.core.services.impls.discounts;

import com.epam.spring.core.domain.User;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BirthdayStrategy implements DiscountStrategy{
    
    private final SimpleDateFormat dayFormat = new SimpleDateFormat("dd");
    private final SimpleDateFormat monthFormat = new SimpleDateFormat("MM");
    private final double DISCOUNT_BITHDAY = 0.05;

    @Override
    public double getDiscount(User user, Date date) {
        double discount = 0;
        String day = dayFormat.format(date);
        String month = monthFormat.format(date);
        if (day.equals(dayFormat.format(user.getBirthday())) && month.equals(monthFormat.format(user.getBirthday()))) {
            discount = DISCOUNT_BITHDAY;
            System.out.println("User '" + user.getName() + "' had got 5% discount by Birthday Strategy");
        }
        return discount;
    }
    
}
