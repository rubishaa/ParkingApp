/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.parkingapplication;

/**
 *
 * @author Lenovo
 */
public class Operation extends Object{
    private int operationID;
    private String plateID;
    private String dateTime;
    private int vehicleType;
    
  
    Operation(int operationID, String plateID, String dateTime,int type){
        this.operationID = operationID;
        this.plateID = plateID;
        this.vehicleType = type;
        this.dateTime = dateTime;
        
    }
    
    public int getOperationID()
    {
        return operationID;
    }
    
    public String getPlateID()
    {
        return plateID;
    }
    
    public DateTime getDateTime()
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
    
    public int getVehicleType()
    {
        return vehicleType;
    }
    
     /* Operation(int operationID){
        this.operationID = operationID;
    }
    
    Operation(int operationID, String plateID,String dateTime){
        this.operationID = operationID;
        this.plateID = plateID;
        this.dateTime = dateTime;
    }
    
    Operation(int operationID, String dateTime){
        this.operationID = operationID;
        this.dateTime = dateTime;
    }*/
}
