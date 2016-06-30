package com.epam.spring.core.services.impls;

import com.epam.spring.core.domain.Event;
import com.epam.spring.core.domain.User;
import com.epam.spring.core.services.impls.discounts.DiscountStrategy;
import com.epam.spring.core.services.interfaces.DiscountService;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.stereotype.Service;

//@Service("discountService")
public class DiscountServiceImplement implements DiscountService {

    List<DiscountStrategy> discountStrategyList = new ArrayList<>();

    public DiscountServiceImplement() {
    }

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
