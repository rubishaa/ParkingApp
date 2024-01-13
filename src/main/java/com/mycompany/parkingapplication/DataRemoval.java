/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.parkingapplication;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 *
 * @author Lenovo
 */

/* This class extedns thread and handle the exit. 
At the exit vechicles details can be deleted (write operation)
Details can be viewed(read operation).
At a time many read operation can take place but only one write operation should be allowed. 
Therefore the readwrite lock was used based on the operation.
*/

public class DataRemoval extends Thread {
    
    private ReentrantReadWriteLock readWriteLock;
    private PettahMultiStoryCarParkManager pmscpm;
    private ArrayList<Operation> listOfOperations = new ArrayList<Operation>();
    private String name;
    private ConcurrentTest testData;
    
    public DataRemoval(PettahMultiStoryCarParkManager pmscpm, ReentrantReadWriteLock readWriteLock, String name) {
		super(name);
		this.pmscpm = pmscpm;
		this.readWriteLock = readWriteLock;
                this.name = name;
                this.testData = new ConcurrentTest();
              
                if("EX1".equals(name))
                {
                    loadConcurrentTestDataEX1();
                }
                else
                {
                    loadConcurrentTestDataEX2();
                }
    }
	
    @Override
    public void run() {
        for (Operation item: listOfOperations )
        {    
            int operationID = item.getOperationID();
            ReentrantReadWriteLock.WriteLock writeLock = readWriteLock.writeLock();
            ReentrantReadWriteLock.ReadLock readLock = readWriteLock.readLock();
            
            switch(operationID)
            {
                case 2:
                   
                    writeLock.lock();
                    System.out.println("Exit on " + name);
                    deleteVehicle(item);
                    writeLock.unlock();
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
    
    private void deleteVehicle(Operation op)
    {
        String plateID = op.getPlateID();
        pmscpm.deleteVehicle(plateID);
    }
    
    private void loadConcurrentTestDataEX1(){
        testData.loadThreadEX1Data();
        listOfOperations = testData.getEX1TestData();
    }
    
    private void loadConcurrentTestDataEX2(){
        testData.loadThreadEX2Data();
        listOfOperations = testData.getEX2TestData();
    }
    
}
