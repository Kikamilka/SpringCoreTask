package com.epam.spring.core;

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

    App(UserService userService, EventService eventService, AuditoriumService audirotiumService,
            DiscountService discountService) {
        this.userService = userService;
        this.eventService = eventService;
        this.audirotiumService = audirotiumService;
        this.discountService = discountService;
    }

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");

        User user = (User) context.getBean("user");
        Auditorium auditorium = (Auditorium) context.getBean("auditorium");
        UserService userService = (UserService) context.getBean("userService");
        EventService eventService = (EventService) context.getBean("eventService");
        AuditoriumService audirotiumService = (AuditoriumService) context.getBean("auditoriumService");
        DiscountService discountService = (DiscountService) context.getBean("discountService");
        App app = new App(userService, eventService, audirotiumService, discountService);
        app.exec(user, auditorium);
    }

    public void exec(User user, Auditorium auditorium) {
        //registrate user
        userService.register(user);
        //get list of booked tickets
        List<Ticket> tickets = userService.getBookedTickets(user);
        System.out.println("Tickets for user '" + user.getName() + "':");
        for (Ticket ticket : tickets) {
            System.out.println(ticket);
        }
        //add auditorium
        audirotiumService.addAuditorium(auditorium);
        System.out.println("Avalable auditoriums: ");
        for (Auditorium avalAuditorium : audirotiumService.getAuditoriums()) {
            System.out.println(avalAuditorium);
        }
        //create event
        Date date = new Date();
        Event event = eventService.create("1", "The Best Comedy", date, date, 3.5, RatingEnum.HIGH);
        //assign auditorium for event
        eventService.assignAuditorium(event, auditorium, date, date);
        System.out.println("Created event: " + eventService.getByName("The Best Comedy"));
        //get discount for user
        discountService.getDiscount(user, event, date);
    }
}
