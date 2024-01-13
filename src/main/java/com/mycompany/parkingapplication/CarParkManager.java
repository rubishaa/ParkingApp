/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.parkingapplication;

import java.math.BigDecimal;

/**
 *
 * @author Lenovo
 */
public interface CarParkManager {
    public void addVehicle(Vehicle obj);
    public Vehicle deleteVehicle(String plateID);
    public void printCurrentVehicles();
    public void printPercentage();
    public void printOldestVehicle();
    public void printLatestVehicle();
    public void printVehicleOnDate(DateTime givenDate);
    public void printCharges(DateTime currentTime);
    
}
