/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.parkingapplication;

/**
 *
 * @author Lenovo
 */

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;

class PettahMultiStoryCarParkManager implements CarParkManager{

    private ArrayList<Vehicle> listOfVehicle = new ArrayList<Vehicle>();
    
   // private static PettahMultiStoryCarParkManager instance = null;
    private double availableSlots = 600; 
    private double chargePerHour = 50;
    private double addCharge = 75;
    private double maxCharge = 1200;
    private int addFromthisHour =3;
    private int bikeCount = 0;
    private boolean enableLift = false;
    double[] floorArray = new double[]{60,60,60,60,60,60,60,60,60,60};
    //double[] floorArray = new double[]{0,0,0,0,0,0,0,0,60,60}; Test lif operation
    int[] vanPriorityFloor = new int[]{1,2,3,4,5,6,0}; // floor will be allocated based on this pripority
    int[] bikePriorityFloor = new int[]{3,4,5,6,1,2,0};
    int[] carPriorityFloor = new int[]{3,4,5,6,1,2,0};
    
    private static final DecimalFormat df = new DecimalFormat("0.00");
	
    public PettahMultiStoryCarParkManager() {
    }
    	
    @Override
    public void addVehicle(Vehicle obj) {
        for(Vehicle item : listOfVehicle) {
            if(item.getPlateID().equals(obj.getPlateID())) {
		System.out.println("This vehicle is already parked.");
		return;
            }
	}
        System.out.println("Before park Total Available slots : "+ df.format(availableSlots));
	boolean slotAssigned = getParkSlot(obj);
        if (slotAssigned)
        {
            listOfVehicle.add(obj);
            System.out.println("After park " + obj.getVehicleType()+ " Available slots in floor "+ obj.getParkFloor() + " is :"
                    + floorArray[obj.getParkFloor()]);        
            System.out.println("After park Total Available slots : "+df.format(availableSlots));   
        }
	else
        {
            System.out.println("No available slots");
        }
    }
    
    @Override
    public Vehicle deleteVehicle(String plateID) {
        for(Vehicle item: listOfVehicle) {
            if(item.getPlateID().equals(plateID)) {
                availableSlots+=item.getSpaceSize();
                floorArray[item.getParkFloor()]+=item.getSpaceSize();
                
                if(item instanceof Bike)
                {
                    bikeCount--;
                    if (bikeCount%3==0)
                    {
                        availableSlots = Math.round(availableSlots);
                        floorArray[item.getParkFloor()] = Math.round(floorArray[item.getParkFloor()]);
                    }
                }           
		System.out.println("Space cleared after deleting a "+item.getVehicleType()+
                        " Total Available Slots : " +df.format(availableSlots));
                System.out.println("Space cleared after deleting a "+item.getVehicleType()+
                        " In Floor : " + item.getParkFloor()+ " available slot is " + floorArray[item.getParkFloor()]);
                
                listOfVehicle.remove(item);
                return item;
                
            }
        }
        System.out.println("Vehicle not found.");
        return null;
    }
    
    public int getBikeCount()
    {
        return bikeCount;
    }
    @Override
    public void printCurrentVehicles()
    {
        if(listOfVehicle.isEmpty()){
            System.out.println("No vehicles parked");
        }
  
        for (int i = listOfVehicle.size()-1; i>=0;i--)
        {
            System.out.println("Vehicle ID: "+listOfVehicle.get(i).getPlateID()+ 
                    " Vehicle Type: "+listOfVehicle.get(i).getVehicleType()
            +" Entry Time: "+listOfVehicle.get(i).getEntryDate().getDateTime()+"\n");
        }
        
    }
    
    @Override
    public void printPercentage()
    {
        if (listOfVehicle.isEmpty())
        {
            System.out.println("No Vehicles Parked");
            return;
        }
        int numCars=0;
	int numBikes=0;
	int numVans=0;
        int numBus=0;
	int numLorry=0;
	int numMiniBus=0;
        int numMiniLorry=0;
        
	for(Vehicle item:listOfVehicle) {
            if(item instanceof Car) {
		numCars++;
            }else if(item instanceof Bike) {
		numBikes++;
            }else if (item instanceof Van) {
		numVans++;
            }
            else if(item instanceof Bus) {
		numBus++;
            }else if (item instanceof Lorry){
		numLorry++;
            }
            else if(item instanceof MiniBus) {
		numMiniBus++;
            }else if (item instanceof MiniLorry){
		numMiniLorry++;
            }
            else{
                System.out.println("Invalid Type");
            }
	}
           
            double size = listOfVehicle.size();
            String carPercentage = df.format(numCars/size*100);
            String bikePercentage = df.format(numBikes/size*100);
            String vanPercentage = df.format(numVans/size*100);
            String busPercentage = df.format(numBus/size*100);
            String lorryPercentage = df.format(numLorry/size*100);
            String miniBusPercentage = df.format(numMiniBus/size*100);
            String miniLorryPercentage = df.format(numMiniLorry/size*100);
            
            System.out.println("Car Percentage is : " + carPercentage);
            System.out.println("Bike Percentage is : " + bikePercentage);
            System.out.println("Van Percentage is : "+vanPercentage);
            System.out.println("Bus Percentage is : "+busPercentage);
            System.out.println("Lorry Percentage is : "+lorryPercentage);
            System.out.println("MiniBus Percentage is : "+miniBusPercentage);
            System.out.println("MiniLorry Percentage is : "+miniLorryPercentage);
            System.out.println("\n");       
        
    }
    
    @Override
    public void printOldestVehicle()
    {
        Vehicle item = listOfVehicle.get(0);
        System.out.println("Old Vehicle ID: "+item.getPlateID()+ " Vehicle Type: "+item.getVehicleType()
            +" Entry Time: "+item.getEntryDate().getDateTime()+"\n");
    }
    
    @Override
    public void printLatestVehicle()
    {
        if (listOfVehicle.isEmpty())
        {
            System.out.println("No Vehicles Parked");
            return;
        }
       
        Vehicle item = listOfVehicle.get(listOfVehicle.size()-1);
        System.out.println("Latest Vehicle ID: "+item.getPlateID()+ " Vehicle Type: "+item.getVehicleType()
            +" Entry Time: "+item.getEntryDate().getDateTime()+"\n");
       
    }
    
    @Override
    public void printVehicleOnDate(DateTime givenDate)
    {
        if (listOfVehicle.isEmpty())
        {
            System.out.println("No Vehicles Parked");
            return;
        }
        int count = 0;
        for(Vehicle item:listOfVehicle) {
            
		if(givenDate.getYear()==item.getEntryDate().getYear() &&
				givenDate.getMonth()==item.getEntryDate().getMonth() && 
						givenDate.getDate() == item.getEntryDate().getDate()) {
                    System.out.println("Vehicle ID: "+item.getPlateID()+ " Vehicle Type: "+item.getVehicleType()
            +" Entry Time: "+item.getEntryDate().getDateTime()+"\n");
                    count+=1;
                    
                }
        }
        
        if (count==0)
        {
          System.out.println("No Vehicles Parked on the given Date");
        }
    }
    
    @Override
    public void printCharges(DateTime currentTime)
    {
         if (listOfVehicle.isEmpty())
        {
            System.out.println("No Vehicles Parked");
            return;
        }
	for(Vehicle item:listOfVehicle) {
            System.out.println("Parked Time : "+item.getEntryDate().getDateTime());
            DateTime entryDateTime = item.getEntryDate();
            int differenceInSeconds = currentTime.compareTo(entryDateTime);
            double differenceInHours = Math.ceil(differenceInSeconds/(60.0*60.0));
            double dayCharge=0;
            double hourCharge = 0;
            double totalCost=0;
            int days = (int)differenceInHours/24;
            System.out.println("Difference : "+df.format(differenceInHours) +" Days "+ days);
	    double hourDifAfterDayDeduct;
            double additional;
         
            if((days>=1) && !("Bike".equals(item.getVehicleType()))) {
                dayCharge =maxCharge*days;
                hourDifAfterDayDeduct =  differenceInHours-days*24;
                
                hourCharge=(hourDifAfterDayDeduct *addCharge)*item.getSpaceSize();
                
            }
            else{
                if (differenceInHours>=3) {
                    additional = (differenceInHours-addFromthisHour) ;
                    hourCharge=((additional*addCharge)+(addFromthisHour *chargePerHour))*item.getSpaceSize();
                }else {
                   hourCharge=(differenceInHours*chargePerHour*item.getSpaceSize());
                }
            }
            
            System.out.println("hour Charge : "+df.format(hourCharge));
            
            totalCost=dayCharge + hourCharge;
            BigDecimal vehicleCharge = new BigDecimal(totalCost);
            System.out.println(item.getPlateID()+" charge is LKR "+df.format(vehicleCharge));
        }		
		
    }
    
    private boolean  getParkSlot(Vehicle obj)
    {
        if (obj instanceof Lorry || obj instanceof Bus )
        {
            if(floorArray[0]>=5)
            {
                floorArray[0] = floorArray[0]-5;
                availableSlots-=5;
                obj.setParkFloor(0);
                return true;
            }
        }
        else if (obj instanceof MiniBus || obj instanceof MiniLorry)
        {
            if(floorArray[0]>=3)
            {
                floorArray[0] = floorArray[0]-3;
                availableSlots-=3;
                obj.setParkFloor(0);
                return true;
            }
        }
        else if (obj instanceof Van)
        {
            for (int x:vanPriorityFloor)
            {
                if(floorArray[x]>=2)
                {
                    floorArray[x] = floorArray[x]-2;
                    availableSlots-=2;
                    obj.setParkFloor(x);
                    return true;
                }
            }
        }
        else if (obj instanceof Bike)
        {
            for (int x:bikePriorityFloor)
            {
                if(floorArray[x]>=0.33)
                {
                    floorArray[x] = floorArray[x]-0.33;
                    availableSlots-=0.33;
                    obj.setParkFloor(x);
                    
                    bikeCount++;
                    if (bikeCount%3==0)
                    {
                        floorArray[x]=Math.round(floorArray[x]);
                        availableSlots=Math.round(availableSlots);
                    }
                
                    return true;
                }
            }
        }
        else if (obj instanceof Car)
        {
            for (int x:carPriorityFloor)
            {
                if(floorArray[x]>=1)
                {
                    floorArray[x] = floorArray[x]-1;
                    availableSlots-=1;
                    obj.setParkFloor(x);
                    return true;
                }
            }
            
            printParkingSlotsStatus();
            
            for(int i=7; i<10;i++)
            {
              if(floorArray[i]>=1)
                {
                    floorArray[i] = floorArray[i]-1;
                    availableSlots-=1;
                    obj.setParkFloor(i);
                    enableLift = true;
                    return true;
                }  
            }
 
            //enable lift
            
        }
        else{//invalid
            
        }
        
        printParkingSlotsStatus();
        return false;
    }
    
    void printParkingSlotsStatus()
    {
        int floor =0;
        for(double x: floorArray)
        {
           System.out.println("Available slots on floor "+floor+" is "+ x);
           floor++;
        }
    }
    
    boolean getLiftStatus()
    {
        return enableLift;
    }

}
    