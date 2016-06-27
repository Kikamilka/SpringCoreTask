package com.epam.spring.core.aspects;

import com.epam.spring.core.domain.Ticket;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
//@Component("luckyWinnerAspect")
public class LuckyWinnerAspect {

    private int luckyTicketsCount;

    public int getLuckyTicketsCount() {
        return luckyTicketsCount;
    }

    @Before("execution(* com.epam.spring.core.Service.Implements.BookingServiceImplement.bookTicket(..)) "
            + "&&args(.., ticket)")
    public void checkLucky(Ticket ticket) {
        if (isLucky()) {
            ticket.setPrice("0");
            System.out.println("Ticket '" + ticket.getNameEvent() + "' has price = " + ticket.getPrice());
        }
    }

    private boolean isLucky() {
        int rand = (int) (Math.random() * 100);
        if (rand % 2 == 0) {
            luckyTicketsCount++;
            return true;
        }
        return false;
    }
}
