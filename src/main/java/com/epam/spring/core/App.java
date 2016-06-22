package com.epam.spring.core;

import com.epam.spring.core.Aspects.CounterAspect;
import com.epam.spring.core.Domain.Auditorium;
import com.epam.spring.core.Domain.Event;
import com.epam.spring.core.Domain.RatingEnum;
import com.epam.spring.core.Domain.Ticket;
import com.epam.spring.core.Domain.User;
import com.epam.spring.core.Service.Interfaces.AuditoriumService;
import com.epam.spring.core.Service.Interfaces.DiscountService;
import com.epam.spring.core.Service.Interfaces.EventService;
import com.epam.spring.core.Service.Interfaces.UserService;
import java.util.Date;
import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

    private final UserService userService;
    private final EventService eventService;
    private final AuditoriumService audirotiumService;
    private final DiscountService discountService;
    private final CounterAspect counterAspect;

    App(UserService userService, EventService eventService, AuditoriumService audirotiumService,
            DiscountService discountService, CounterAspect counterAspect) {
        this.userService = userService;
        this.eventService = eventService;
        this.audirotiumService = audirotiumService;
        this.discountService = discountService;
        this.counterAspect = counterAspect;
    }

    public static void main(String[] args) {
        
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        ApplicationContext contextUsers = new ClassPathXmlApplicationContext("users.xml");
        ApplicationContext contextAuditorium = new ClassPathXmlApplicationContext("auditorium.xml");
        
        User user = (User) contextUsers.getBean("user2");
        Auditorium auditorium = (Auditorium) contextAuditorium.getBean("auditorium");
        UserService userService = (UserService) context.getBean("userService");
        EventService eventService = (EventService) context.getBean("eventService");
        AuditoriumService audirotiumService = (AuditoriumService) context.getBean("auditoriumService");
        DiscountService discountService = (DiscountService) context.getBean("discountService");
        CounterAspect counterAspect = (CounterAspect) context.getBean("counterAspect");
        
        App app = new App(userService, eventService, audirotiumService, discountService, counterAspect);
        
        app.exec(user, auditorium);
    }

    public void exec(User user, Auditorium auditorium) {

        userService.register(user);

        List<Ticket> tickets = userService.getBookedTickets(user);
        System.out.println("Tickets for user '" + user.getName() + "':");
        for (Ticket ticket : tickets) {
            System.out.println(ticket);
        }

        audirotiumService.addAuditorium(auditorium);
        System.out.println("Avalable auditoriums: ");
        for (Auditorium avalAuditorium : audirotiumService.getAuditoriums()) {
            System.out.println(avalAuditorium);
        }

        Date date = new Date(); //текущая дата
        Event event = eventService.create("001", "The Trash", date, date, 3.5, RatingEnum.HIGH);
        eventService.assignAuditorium(event, auditorium, date, date);
        System.out.println("Created event: " + eventService.getByName("The Trash"));

        discountService.getDiscount(user, event, date);
        
        counterAspect.getCounterAspectInfo();
    }
}
