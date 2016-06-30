package com.epam.spring.core.aspects;

import com.epam.spring.core.domain.User;
import java.util.HashMap;
import java.util.Map;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
//@Component("discountAspect")
public class DiscountAspect {

    private final Map<User, Integer> discountCounterForUser = new HashMap<>();
    private final Map<String, Integer> globalDiscountCounter = new HashMap<>();
    
    private static final String BIRTHDAY_DISCOUNT = "BIRTHDAY_DISCOUNT";
    private static final String TENTH_DISCOUNT = "TENTH_DISCOUNT";

    public Map<User, Integer> getDiscountCounter() {
        return discountCounterForUser;
    }

    public Map<String, Integer> getGlobalDiscountCounter() {
        return globalDiscountCounter;
    }

    @AfterReturning(pointcut = "execution(* com.epam.spring.core.Service.Implements.Discounts.BirthdayStrategy.getDiscount(..))"
            + "&& args(user, ..)", returning = "discount")
    public void countGetBirthdayDiscount(User user, double discount) {
        if (discount != 0) {
            int countGlobalBirthdayDiscount = globalDiscountCounter.containsKey(BIRTHDAY_DISCOUNT) ? globalDiscountCounter.get(BIRTHDAY_DISCOUNT) : 0;
            globalDiscountCounter.put(BIRTHDAY_DISCOUNT, ++countGlobalBirthdayDiscount);
            int countUserDiscount = discountCounterForUser.containsKey(user) ? discountCounterForUser.get(user) : 0;
            discountCounterForUser.put(user, ++countUserDiscount);
        }
    }
    
    @AfterReturning(pointcut = "execution(* com.epam.spring.core.Service.Implements.Discounts.EveryTenthStrategy.getDiscount(..))"
            + "&& args(user, ..)", returning = "discount")
    public void countGetTenthDiscount(User user, double discount) {
        if (discount != 0) {
            int countGlobalTenthDiscount = globalDiscountCounter.containsKey(TENTH_DISCOUNT) ? globalDiscountCounter.get(TENTH_DISCOUNT) : 0;
            globalDiscountCounter.put(TENTH_DISCOUNT, ++countGlobalTenthDiscount);
            int countUserDiscount = discountCounterForUser.containsKey(user) ? discountCounterForUser.get(user) : 0;
            discountCounterForUser.put(user, ++countUserDiscount);
        }
    }

    public void getDiscountAspectInfo(User user) {
        int count;
        count = (globalDiscountCounter.get(BIRTHDAY_DISCOUNT) != null) ? globalDiscountCounter.get(BIRTHDAY_DISCOUNT) : 0;
        System.out.println("BIRTHDAY_DISCOUNT was got " + count + " times");
        
        count = (globalDiscountCounter.get(TENTH_DISCOUNT) != null) ? globalDiscountCounter.get(TENTH_DISCOUNT) : 0;
        System.out.println("TENTH_DISCOUNT was got " + count + " times");

        count = (discountCounterForUser.get(user) != null) ? discountCounterForUser.get(user) : 0;
        System.out.println("Discount for " + user.getName() + " was got " + count + " times");
    }
}
