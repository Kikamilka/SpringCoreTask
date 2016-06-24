package com.epam.spring.core;

import com.epam.spring.core.aspects.CounterAspect;
import com.epam.spring.core.aspects.DiscountAspect;
import com.epam.spring.core.aspects.LuckyWinnerAspect;
import com.epam.spring.core.domain.Auditorium;
import com.epam.spring.core.domain.Event;
import com.epam.spring.core.domain.RatingEnum;
import com.epam.spring.core.domain.Ticket;
import com.epam.spring.core.domain.User;
import com.epam.spring.core.services.interfaces.AuditoriumService;
import com.epam.spring.core.services.interfaces.BookingService;
import com.epam.spring.core.services.interfaces.DiscountService;
import com.epam.spring.core.services.interfaces.EventService;
import com.epam.spring.core.services.interfaces.UserService;
import java.util.Date;
import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

    private final UserService userService;
    private final EventService eventService;
    private final AuditoriumService audirotiumService;
    private final DiscountService discountService;
    private final BookingService bookingService;
    private final CounterAspect counterAspect;
    private final DiscountAspect discountAspect;
    private final LuckyWinnerAspect luckyWinnerAspect;

    App(UserService userService, EventService eventService, AuditoriumService audirotiumService,
            DiscountService discountService, BookingService bookingService,
            CounterAspect counterAspect, DiscountAspect discountAspect, LuckyWinnerAspect luckyWinnerAspect) {
        this.userService = userService;
        this.eventService = eventService;
        this.audirotiumService = audirotiumService;
        this.discountService = discountService;
        this.bookingService = bookingService;
        this.counterAspect = counterAspect;
        this.discountAspect = discountAspect;
        this.luckyWinnerAspect = luckyWinnerAspect;
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
        BookingService bookingService = (BookingService) context.getBean("bookingService");

        CounterAspect counterAspect = (CounterAspect) context.getBean("counterAspect");
        DiscountAspect discountAspect = (DiscountAspect) context.getBean("discountAspect");
        LuckyWinnerAspect luckyWinnerAspect = (LuckyWinnerAspect) context.getBean("luckyWinnerAspect");

        App app = new App(userService, eventService, audirotiumService, discountService, bookingService, counterAspect, discountAspect, luckyWinnerAspect);

        app.exec(user, auditorium);

        User userA = (User) contextUsers.getBean("user3");
        Ticket ticket = (Ticket) context.getBean("ticket1");
        app.checkTicketAspect(userA, ticket);
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
        discountAspect.getDiscountAspectInfo(user);
    }

    private void checkTicketAspect(User user, Ticket ticket) {
        userService.register(user);
        bookingService.bookTicket(user, ticket);
        System.out.println("Count lucky tickets (LuckyWinnerAspect) = " + luckyWinnerAspect.getLuckyTicketsCount());
        List<Ticket> tickets = userService.getBookedTickets(user);
        System.out.println("Tickets for user '" + user.getName() + "':");
        for (Ticket ticketU : tickets) {
            System.out.println(ticketU);
        }
    }
}
