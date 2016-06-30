package com.epam.spring.core.dao.impls.exeptions;

public class DaoDbExeption extends RuntimeException{

    public DaoDbExeption(String message, Throwable cause) {
        super(message, cause);
    }

    public DaoDbExeption(String message) {
        super(message);
    }

    public DaoDbExeption(Throwable thrwbl) {
        super(thrwbl);
    }
    
}