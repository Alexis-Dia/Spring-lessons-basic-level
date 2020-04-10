package com.journaldev.spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;

public class SpringMainClass {

    public static void main(String[] args) throws SQLException {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.scan("com.journaldev.spring");
        context.refresh();
        System.out.println("Refreshing the spring context");
        DBConnection dbConnection = context.getBean(DBConnection.class);

        dbConnection.printDBConfigs();

        // close the spring context
        context.close();
    }

}
