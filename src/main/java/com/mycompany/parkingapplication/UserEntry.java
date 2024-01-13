/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.parkingapplication;

import java.util.Scanner;

/**
 *
 * @author Lenovo
 */
public class UserEntry {
    private static PettahMultiStoryCarParkManager pmsCarParkManager = new PettahMultiStoryCarParkManager() ;
    
    public UserEntry(){
    }
    public int enterVehicleDetails()
    {
        System.out.println("Welcome to PettahMultiStoryCarParkManager! Choose your action");
            System.out.println("1: Add Vehicle");
            System.out.println("2: Delete Vehicle");
            System.out.println("3: Print Current Vehicles");
            System.out.println("4: Print percentage of vehicles");
            System.out.println("5: Print oldest vehicle");
            System.out.println("6: Print latest vehicle");
            System.out.println("7: Print vehicles parked on a specified day");
            System.out.println("8: Print parking charges");
            System.out.println("0: Exit");
            System.out.println("Type your input:");
            Scanner userInput = new Scanner(System.in);
            int choice = userInput.nextInt();
            
            switch(choice){
                case 1:
                    addVehicle();
                    break;
                case 2:
                    deleteVehicle();
                    break;
                case 3:
                    printCurrentVehicles();
                    break;
                case 4:
                    printPercentage();
                    break;
                case 5:
                    printOldestVehicle();
                    break;
                case 6:
                    printLatestVehicle();
                    break;
                case 7:
                    printVehicleOnDate();
                    break;
                case 8:
                    printCharges();
                    break;
                case 0:
                    System.exit(0);
                    break;
                default:
                    break;
                    
            }
            
       return choice;
    }
    
    public static void addVehicle() {
        System.out.println("Select the vehicle Type: 1:Bike 2:Car 3:Van 4:MiniBus 5:MiniLorry 6:Bus 7:Lorry");
        Scanner sc = new Scanner(System.in);
        int type = sc.nextInt();
        if (type<1 || type >7)
        {
            System.out.println("Vehicle Type Not allowed");
            return;
        }
        System.out.println("Enter Plate ID :");
	String plateID = sc.next();
        System.out.println("Enter the date and time (YYYY/MM/DD-HH:mm:ss)");
	String dateTime=sc.next();		
        String[] date =dateTime.split("-");
	String[] dateString= date[0].split("/");
	String[] timeString=date[1].split(":");
        DateTime entryTime=new DateTime(Integer.parseInt(dateString[0]),
				Integer.parseInt(dateString[1]),
				Integer.parseInt(dateString[2]),
				Integer.parseInt(timeString[0]),
				Integer.parseInt(timeString[1]),
				Integer.parseInt(timeString[2]));
        VehicleObject creater = new VehicleObject();
	Vehicle vehicle = creater.createVehicle(type, plateID, entryTime);
        pmsCarParkManager.addVehicle(vehicle);
    }

    private static void deleteVehicle() {
        System.out.println("Enter the plate ID for deletion");
        Scanner sc = new Scanner(System.in);
        String plateID =sc.next();
        pmsCarParkManager.deleteVehicle(plateID);
        Operation op = new Operation(2,plateID,"",0);
    }

    private static void printCurrentVehicles() {
        pmsCarParkManager.printCurrentVehicles();
    }

    private static void printPercentage() {
        pmsCarParkManager.printPercentage();
    }

    private static void printOldestVehicle() {
        pmsCarParkManager.printOldestVehicle();
    }

    private static void printLatestVehicle() {
        pmsCarParkManager.printLatestVehicle();
    }

    private static void printVehicleOnDate() {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter a Date to Find (YYYY/MM/DD-HH:mm:ss) : ");
	String checkThisTime=sc.next();
	String[] date =checkThisTime.split("-");
	String[] dateString= date[0].split("/");
	String[] timeString=date[1].split(":");
	DateTime givenDate=new DateTime(Integer.parseInt(dateString[0]),
				Integer.parseInt(dateString[1]),
				Integer.parseInt(dateString[2]),
				Integer.parseInt(timeString[0]),
				Integer.parseInt(timeString[1]),
				Integer.parseInt(timeString[2]));
        pmsCarParkManager.printVehicleOnDate(givenDate);
    }

    private static void printCharges() {
	Scanner sc = new Scanner(System.in);
	System.out.println("Enter the leaving time : (YYYY/MM/DD - HH:mm:ss)");
	String leavingTime =sc.next();
	String[] arr1= leavingTime.split("-");
	String[] dateString= arr1[0].split("/");
	String[] timeString=arr1[1].split(":");
				
	DateTime currentTime=new DateTime(Integer.parseInt(dateString[0]),
		Integer.parseInt(dateString[1]),Integer.parseInt(dateString[2]),
		Integer.parseInt(timeString[0]),Integer.parseInt(timeString[1]),Integer.parseInt(timeString[2]));
        pmsCarParkManager.printCharges(currentTime);
    }
    
}
