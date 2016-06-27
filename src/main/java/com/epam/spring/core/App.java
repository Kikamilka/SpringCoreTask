package com.epam.spring.core;

import com.epam.spring.core.services.interfaces.AuditoriumService;
import com.epam.spring.core.services.interfaces.BookingService;
import com.epam.spring.core.services.interfaces.DiscountService;
import com.epam.spring.core.services.interfaces.EventService;
import com.epam.spring.core.services.interfaces.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

    private UserService userService;
    private EventService eventService;
    private AuditoriumService auditoriumService;
    private DiscountService discountService;
    private BookingService bookingService;
    //private final CounterAspect counterAspect;
    //private final DiscountAspect discountAspect;
    //private final LuckyWinnerAspect luckyWinnerAspect;
    private String emailUser;
    private String nameEvent;

    public App() {
    }

    App(UserService userService, EventService eventService, AuditoriumService auditoriumService,
            DiscountService discountService, BookingService bookingService) {
        this.userService = userService;
        this.eventService = eventService;
        this.auditoriumService = auditoriumService;
        this.discountService = discountService;
        this.bookingService = bookingService;
        //this.counterAspect = counterAspect;
        //this.discountAspect = discountAspect;
        //this.luckyWinnerAspect = luckyWinnerAspect;
    }

    public UserService getUserService() {
        return userService;
    }

    public EventService getEventService() {
        return eventService;
    }

    public AuditoriumService getAuditoriumService() {
        return auditoriumService;
    }

    public BookingService getBookingService() {
        return bookingService;
    }

    public DiscountService getDiscountService() {
        return discountService;
    }

    public String getEmailUser() {
        return emailUser;
    }

    public void setEmailUser(String emailUser) {
        this.emailUser = emailUser;
    }

    public String getNameEvent() {
        return nameEvent;
    }

    public void setNameEvent(String nameEvent) {
        this.nameEvent = nameEvent;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public void setEventService(EventService eventService) {
        this.eventService = eventService;
    }

    public void setDiscountService(DiscountService discountService) {
        this.discountService = discountService;
    }

    public void setBookingService(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    public void setAuditoriumService(AuditoriumService auditoriumService) {
        this.auditoriumService = auditoriumService;
    }

    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
        App app = (App) ctx.getBean("app");
        System.out.println(String.format("User with email (%s)", app.getEmailUser()));
        System.out.println(String.format("User name: %s",
                app.getUserService().getUserByEmail(app.getEmailUser()).getName()));
        System.out.println(app.getEventService().getByName(app.getNameEvent()));
    }    
}
