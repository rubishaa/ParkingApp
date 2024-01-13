/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.parkingapplication;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 *
 * @author Lenovo
 */
public class ParkingApplication {


    Semaphore liftAccess = new Semaphore(2);
    
    public static void main(String[] args) {
              
        concurrentApplication();
        //userApplication();
        //functionalTest();
        
    }
    
    public static void concurrentApplication(){
        PettahMultiStoryCarParkManager pmsCarParkManager = new PettahMultiStoryCarParkManager();
        ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock(true);
        
        DataEntry entryEN1 = new DataEntry(pmsCarParkManager,readWriteLock,"EN1");
        DataEntry entryEN2 = new DataEntry(pmsCarParkManager,readWriteLock,"EN2");
        DataRemoval removeEX1 = new DataRemoval(pmsCarParkManager,readWriteLock,"EX1");
        DataRemoval removeEX2 = new DataRemoval(pmsCarParkManager,readWriteLock,"EX2");
        
        entryEN1.setPriority(8);  // set high priority to north entrances
        entryEN2.setPriority(8);
        
        entryEN1.start();
        entryEN2.start();
        removeEX1.start();
        removeEX2.start();
    }
    
    public static void userApplication(){
        while(true)
        {
            UserEntry userEntry = new UserEntry();
            userEntry.enterVehicleDetails();
        }
    }
        
    /*Only two lifts are in use based on the slot availabilty. While the lift in operation view and exit operation
    be perfomred. Therefore the outside the writelock semaphore has been used.*/
    public void liftOperation()
    {
        try {
            liftAccess.acquire();
  
            System.out.println(Thread.currentThread().getName() + " inside lift operation ");
            Thread.sleep(1000);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
 
        finally {
            liftAccess.release();
            System.out.println(Thread.currentThread().getName() + " outside of lift operation ");
        }
    }
    
    public static void functionalTest(){
        FunctionalTest test = new FunctionalTest();
        test.executeTest();
    }
    
    
    
}

/* reference 
https://www.geeksforgeeks.org/how-to-use-counting-semaphore-in-concurrent-java-application/ */