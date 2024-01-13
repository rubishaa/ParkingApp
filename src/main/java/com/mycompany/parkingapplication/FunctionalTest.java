/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.parkingapplication;

/**
 *
 * @author Lenovo
 */
public class FunctionalTest {
    
    PettahMultiStoryCarParkManager pmscpm = new PettahMultiStoryCarParkManager();
    
    public void executeTest(){
        testAddVehicle();
        
        testPrintFunctions();
        
        testCharges();
    }
    
    
    public void testAddVehicle()
    {
        System.out.println("Add  Delete Vehicle Test");
        VehicleObject creater = new VehicleObject();
	String dateTime="2022/07/28-13:24:34";		
	DateTime entryTime =  convertDateTime(dateTime);       
        
	Vehicle vehicle = creater.createVehicle(1, "Bike1", entryTime);
        pmscpm.addVehicle(vehicle);
        
        dateTime="2022/07/28-14:24:34";		
	entryTime =  convertDateTime(dateTime); 
        
        vehicle = creater.createVehicle(1, "Bike2", entryTime);
        pmscpm.addVehicle(vehicle);
        
        vehicle = creater.createVehicle(2, "Car1", entryTime);
        pmscpm.addVehicle(vehicle);
                        
        vehicle = creater.createVehicle(1, "Bike3", entryTime);
        pmscpm.addVehicle(vehicle);
        
        vehicle = creater.createVehicle(5, "MiniLorry1", entryTime);
        pmscpm.addVehicle(vehicle);
        
        vehicle = creater.createVehicle(6, "Bus1", entryTime);
        pmscpm.addVehicle(vehicle);
        
        vehicle = creater.createVehicle(1, "Bike4", entryTime);
        pmscpm.addVehicle(vehicle);
        
        vehicle = creater.createVehicle(7, "Lorry1", entryTime);
        pmscpm.addVehicle(vehicle);
        
        pmscpm.deleteVehicle("Bike2");
        pmscpm.deleteVehicle("Lorry1");
        
        dateTime="2022/07/29-11:24:34";		
	entryTime =  convertDateTime(dateTime); 
        
        vehicle = creater.createVehicle(4, "MiniBus1", entryTime);
        pmscpm.addVehicle(vehicle);
        
        pmscpm.deleteVehicle("Bike3");
        pmscpm.deleteVehicle("Bike4");
        
        vehicle = creater.createVehicle(3, "Van1", entryTime);
        pmscpm.addVehicle(vehicle);
        
        vehicle = creater.createVehicle(2, "Car2", entryTime);
        pmscpm.addVehicle(vehicle);
        
        dateTime="2022/07/29-14:24:34";		
	entryTime =  convertDateTime(dateTime); 
        
        vehicle = creater.createVehicle(7, "Lorry2", entryTime);
        pmscpm.addVehicle(vehicle);
        
        
    }
    
    public void testPrintFunctions()
    {
        System.out.println("Print Functions Test");
        
        pmscpm.printCurrentVehicles();
        
        pmscpm.printPercentage();
        
        pmscpm.printOldestVehicle();
        
        pmscpm.printLatestVehicle();
        
        String dateTime="2022/07/28-00:00:00";		
	DateTime entryTime =  convertDateTime(dateTime); 
        
        pmscpm.printVehicleOnDate(entryTime);
    }
    
    public void testCharges()
    {
        System.out.println("Charge calculation Test");
        String dateTime="2022/07/29-15:00:00";		
	DateTime currentTime =  convertDateTime(dateTime); 
        
        pmscpm.printCharges(currentTime);
    }
    
    
    public DateTime convertDateTime(String dateTime)
    {
        String[] date =dateTime.split("-");
	String[] dateString= date[0].split("/");
	String[] timeString=date[1].split(":");
        DateTime entryTime=new DateTime(Integer.parseInt(dateString[0]),
				Integer.parseInt(dateString[1]),
				Integer.parseInt(dateString[2]),
				Integer.parseInt(timeString[0]),
				Integer.parseInt(timeString[1]),
				Integer.parseInt(timeString[2]));
        
        return entryTime;
    }
    
}
