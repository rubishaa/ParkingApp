/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.parkingapplication;

/**
 *
 * @author Lenovo
 */


public abstract class Vehicle extends Object implements Comparable<Vehicle> {
	
	@Override
	public int compareTo(Vehicle o) {
		return this.entryTime.compareTo(o.entryTime);
	}
	
	private String plateID;
	private DateTime entryTime;
        private double spaceSize;
        private String type;
        private int parkFloor;
	
	public Vehicle(String plateID,DateTime entryTime, double size, String type){
		this.plateID=plateID;
		this.entryTime=entryTime;
                this.spaceSize = size;
                this.type = type;
	}
	
	public String getPlateID() {
		return plateID;
	}
	public void setIdPlate(String plateID) {
		this.plateID=plateID;
	}
	
	public DateTime getEntryDate() {
		return entryTime;
	}
        
        public double getSpaceSize(){
            return spaceSize;
        }
        
        public String getVehicleType()
        {
            return type;
        }
	public void setEntryDate(DateTime entryTime) {
		this.entryTime = entryTime;
	}
        
        public void setParkFloor(int parkFloor){
            this.parkFloor = parkFloor;
        }
        
        public int getParkFloor(){
            return parkFloor;
        }
	
	
	

}

