/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.parkingapplication;

/**
 *
 * @author Lenovo
 */
public class VehicleObject {
    public Vehicle createVehicle(int type, String plateID, DateTime entryTime) {
		
        Vehicle obj=null;	
	switch(type) 
        {
            case 1:	
		obj=new Bike(plateID,entryTime);
		break;
            case 2:	
		obj=new Car(plateID,entryTime);
		break;
            case 3:	
		obj=new Van(plateID,entryTime);
		break;
            case 4:	
		obj=new MiniBus(plateID,entryTime);
		break;
            case 5:	
		obj=new MiniLorry(plateID,entryTime);
		break;
            case 6:	
		obj=new Bus(plateID,entryTime);
		break;
            case 7:	
		obj=new Lorry(plateID,entryTime);
		break;	
            default :
		System.out.println("Invalid Choice");		
		
        }
        return obj;
    }    
}
