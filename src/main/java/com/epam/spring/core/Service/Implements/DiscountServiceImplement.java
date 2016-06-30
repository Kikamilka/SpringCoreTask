package com.epam.spring.core.Service.Implements;

import com.epam.spring.core.Domain.Event;
import com.epam.spring.core.Domain.User;
import com.epam.spring.core.Service.Implements.Discounts.DiscountStrategy;
import com.epam.spring.core.Service.Interfaces.DiscountService;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.stereotype.Service;

@Service("discountService")
public class DiscountServiceImplement implements DiscountService {

    List<DiscountStrategy> discountStrategyList = new ArrayList<>();

    @Override
    public double getDiscount(User user, Event event, Date date) {
        double discount = 0.0;
        for (DiscountStrategy discountStrategy : discountStrategyList) {
            discount += discountStrategy.getDiscount(user, date);
        }
        System.out.println("Common Dicount: " + (int) (discount * 100) + '%');
        return discount;
    }

    public void setDiscountStrategyList(List<DiscountStrategy> discountStrategyList) {
        this.discountStrategyList = discountStrategyList;
    }
}
