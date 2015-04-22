package com;

import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Enumeration;
import java.util.Timer;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;


public class ContextHandler implements ServletContextListener {

    private Timer timer = null;
    private Runnable task = null;
    public void contextInitialized(ServletContextEvent arg0) {


   
    }
    
    
   
    public void contextDestroyed(ServletContextEvent arg0) {

        System.out.println("#################### Context Destroyed ###################");

        if (timer != null) {
            timer.cancel();
        }
        
       
        
        Enumeration<Driver> drivers = DriverManager.getDrivers();
       
        while (drivers.hasMoreElements()) {
            
            Driver driver = drivers.nextElement();
            
            try {
                DriverManager.deregisterDriver(driver);
                
                System.out.println(String.format("Desregistrando driver JDBC: %s", driver));
                
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println(String.format("Erro ao desregistrar driver %s", driver));
            }
        }
    }
    
    
    public static void main(String[] args) {
    	
    	ContextHandler nContextHandler = new ContextHandler();
    	nContextHandler.contextInitialized(null);
    	
    	
    }
    

}
