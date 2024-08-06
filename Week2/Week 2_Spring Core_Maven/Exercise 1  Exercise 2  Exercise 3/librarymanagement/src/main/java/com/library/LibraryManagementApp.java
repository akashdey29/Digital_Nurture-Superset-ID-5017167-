package com.library;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.library.service.*;
// Exercise 1: Configuring a Basic Spring Application
public class LibraryManagementApp {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
        // Exercise 2: Implementing Dependency Injection
        BookService bookService=context.getBean(BookService.class);
        bookService.serviceMethod();
        bookService.printBookRepository();
        context.close();
    }
}