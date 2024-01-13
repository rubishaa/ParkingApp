/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.parkingapplication;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 *
 * @author Lenovo
 */

/* This class extedns thread and handle the entrance. 
At the entrance vechicles details can be added (write operation)
Details can be viewed(read operation).
At a time many read operation can take place but only one write operation should be allowed. 
Therefore the readwrite lock was used based on the operation.
*/

public class DataEntry extends Thread {
    private ReentrantReadWriteLock readWriteLock;
    private PettahMultiStoryCarParkManager pmscpm;
    private ArrayList<Operation> listOfOperations = new ArrayList<Operation>();
    private String name;
    private ConcurrentTest testData;
        
    public DataEntry(PettahMultiStoryCarParkManager pmscpm, ReentrantReadWriteLock readWriteLock, String name) {
		super(name);
		this.pmscpm = pmscpm;
		this.readWriteLock = readWriteLock;
                this.name = name;
                this.testData = new ConcurrentTest();
                if("EN1".equals(name))
                {
                    loadConcurrentTestDataEN1();
                }
                else
                {
                    loadConcurrentTestDataEN2();
                }
    }
	
    @Override
    public void run() {
        System.out.println(name);
        for (Operation item: listOfOperations )
        {       
            int operationID = item.getOperationID();
            ReentrantReadWriteLock.WriteLock writeLock = readWriteLock.writeLock();
            ReentrantReadWriteLock.ReadLock readLock = readWriteLock.readLock();
            switch(operationID)
            {
                case 1:
                    writeLock.lock();
                    System.out.println("Entry on " + name);
                    addVehicle(item);
                    boolean liftNeed = pmscpm.getLiftStatus();
                    writeLock.unlock();
                    if (liftNeed)
                    {
                        getLiftAccess();
                    }
                    break;
                case 3:
                    readLock.lock();
                    System.out.println("printCurrentVehicles on " + name);
                    pmscpm.printCurrentVehicles();;
                    readLock.unlock();
                    break;
                case 4:
                    readLock.lock();
                    System.out.println("printPercentage on " + name);
                    pmscpm.printPercentage();
                    readLock.unlock();
                    break;
                case 5:
                    readLock.lock();
                    System.out.println("printOldestVehicle on " + name);
                    pmscpm.printOldestVehicle();;
                    readLock.unlock();
                    break;
                case 6:
                    readLock.lock();
                    System.out.println("printLatestVehicle on " + name);
                    pmscpm.printLatestVehicle();
                    readLock.unlock();
                    break;
                case 7:
                    readLock.lock();
                    System.out.println("printVehicleOnDate " + name);
                    pmscpm.printVehicleOnDate(item.getDateTime());
                    readLock.unlock();
                    break;
                case 8:
                    readLock.lock();
                    System.out.println("Read on printCharges " + name);
                    pmscpm.printCharges(item.getDateTime());
                    readLock.unlock();
                    break;
                default:
                    break;
            }          
        }    
		
	
    }  
    
    
    private void addVehicle(Operation op)
    {     
        int type = op.getVehicleType();
        if (type == 2)                                            //high priortiy for car at entrance 
        {
            Thread.currentThread().setPriority(MAX_PRIORITY);
        }
        else if ((type ==1) && (pmscpm.getBikeCount()%3 ==0))    //low priority for bike if no partial slot
        {
            Thread.currentThread().setPriority(MIN_PRIORITY);
        }
        else
        {
            Thread.currentThread().setPriority(NORM_PRIORITY);
        }
        DateTime entryTime = op.getDateTime();
        String plateID = op.getPlateID();
        VehicleObject creater = new VehicleObject();
	Vehicle vehicle = creater.createVehicle(type, plateID, entryTime);
        pmscpm.addVehicle(vehicle);
        Thread.currentThread().setPriority(8);
    }
    
    private void getLiftAccess()
    {
        final ParkingApplication liftAccess = new ParkingApplication();
        liftAccess.liftOperation();
    }
    
    private void loadConcurrentTestDataEN1(){
        testData.loadThreadEN1Data();
        listOfOperations = testData.getEN1TestData();
    }
    
    private void loadConcurrentTestDataEN2(){
        testData.loadThreadEN2Data();
        listOfOperations = testData.getEN2TestData();
    }

    
    
}
