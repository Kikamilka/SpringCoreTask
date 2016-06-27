package com.epam.spring.core.aspects;

import java.util.HashMap;
import java.util.Map;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
//@Component("counterAspect")
public class CounterAspect {

    private final Map<String, Integer> counter  = new HashMap<>();
    int eventCounter = 0;
    int priceCounter = 0;
    int ticketCounter = 0;
    private static final String EVENT_KEY = "EVENT";
    private static final String PRICE_KEY = "PRICE";
    private static final String TICKET_KEY = "TICKET";

    @AfterReturning("execution(* com.epam.spring.core.Service.Implements.EventServiceImplement.getByName(..))")
    public void countGetEventByName() {
        eventCounter++;
        counter.put(EVENT_KEY, eventCounter);
        //System.out.println("was called countGetEventByName()");
    }

    @AfterReturning("execution(* com.epam.spring.core.Service.Implements.BookingServiceImplement.getTicketPrice(..))")
    public void countGetTicketPrice() {
        priceCounter++;
        counter.put(PRICE_KEY, priceCounter);
        //System.out.println("was called countGetTicketPrice()");
    }

    @AfterReturning("execution(* com.epam.spring.core.Service.Implements.BookingServiceImplement.bookTicket(..))")
    public void countBookTicket() {
        ticketCounter++;
        counter.put(TICKET_KEY, ticketCounter);
        //System.out.println("was called countBookTicket()");
    }

    public void getCounterAspectInfo() {
        int count;
        count = (counter.get(EVENT_KEY) != null) ? counter.get(EVENT_KEY) : 0;
        System.out.println("Get event by name (CounterAspect) was called " + count + " times");

        count = (counter.get(PRICE_KEY) != null) ? counter.get(PRICE_KEY) : 0;
        System.out.println("Get ticket price (CounterAspect) was called " + count + " times");

        count = (counter.get(TICKET_KEY) != null) ? counter.get(TICKET_KEY) : 0;
        System.out.println("Book ticket (CounterAspect) was called " + count + " times");
    }

}
