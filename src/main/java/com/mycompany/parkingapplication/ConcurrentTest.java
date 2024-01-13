/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.parkingapplication;

import java.util.ArrayList;

/**
 *
 * @author Lenovo
 */
public class ConcurrentTest{
    
    public ArrayList<Operation> listOfOperationsEN1 = new ArrayList<Operation>();
    public ArrayList<Operation> listOfOperationsEN2 = new ArrayList<Operation>();
    public ArrayList<Operation> listOfOperationsEX1 = new ArrayList<Operation>();
    public ArrayList<Operation> listOfOperationsEX2 = new ArrayList<Operation>();

    public ConcurrentTest() {
    }
    
   
    
    public void loadThreadEN1Data()
    {
        Operation op1 = new Operation(1,"NP1234","2022/07/12-12:34:34",1);
        Operation op2 = new Operation(1,"NP1235","2022/07/12-13:34:34",2);
        Operation op3 = new Operation(1,"NP1236","2022/07/12-14:34:34",3);
        Operation op4 = new Operation(4,"","",0);
        Operation op5 = new Operation(7,"","2022/07/12-15:34:34",0);
        Operation op6 = new Operation(8,"","2022/07/12-16:34:34",0);
        Operation op7 = new Operation(3,"","",0);
        Operation op8 = new Operation(5,"","",0);
        Operation op9 = new Operation(1,"NP1237","2022/07/12-17:34:34",4);
        Operation op10 = new Operation(1,"NP1238","2022/07/12-16:34:34",5);
        Operation op11 = new Operation(1,"NP1239","2022/07/12-15:34:34",6);
        Operation op12 = new Operation(1,"NP1230","2022/07/12-12:24:34",7);
        Operation op13 = new Operation(7,"","2022/07/12-11:24:34",0);
        Operation op14 = new Operation(7,"","2022/07/13-11:14:34",0);
        Operation op15 = new Operation(5,"","",0);
        listOfOperationsEN1.add(op1);
        listOfOperationsEN1.add(op2);
        listOfOperationsEN1.add(op3);
        listOfOperationsEN1.add(op4);
        listOfOperationsEN1.add(op5);
        listOfOperationsEN1.add(op6);
        listOfOperationsEN1.add(op7);
        listOfOperationsEN1.add(op8);
        listOfOperationsEN1.add(op9);
        listOfOperationsEN1.add(op10);
        listOfOperationsEN1.add(op11);
        listOfOperationsEN1.add(op12);
        listOfOperationsEN1.add(op13);
        listOfOperationsEN1.add(op14);
        listOfOperationsEN1.add(op15);
    }
    
    public void loadThreadEN2Data()
    {
        Operation op1 = new Operation(1,"WP1234","2022/07/12-12:34:34",1);
        Operation op2 = new Operation(1,"WP1235","2022/07/12-13:34:34",2);
        Operation op3 = new Operation(1,"WP1236","2022/07/12-14:34:34",3);
        Operation op4 = new Operation(4,"","",0);
        Operation op5 = new Operation(7,"","2022/07/12-15:34:34",0);
        Operation op6 = new Operation(8,"","2022/07/12-16:34:34",0);
        Operation op7 = new Operation(3,"","",0);
        Operation op8 = new Operation(5,"","",0);
        Operation op9 = new Operation(1,"WP1237","2022/07/12-17:34:34",4);
        Operation op10 = new Operation(1,"WP1238","2022/07/12-16:34:34",5);
        Operation op11 = new Operation(1,"WP1239","2022/07/12-15:34:34",6);
        Operation op12 = new Operation(1,"WP1230","2022/07/13-12:24:34",7);
        Operation op13 = new Operation(7,"","2022/07/12-11:24:34",0);
        Operation op14 = new Operation(7,"","2022/07/12-11:14:34",0);
        Operation op15 = new Operation(5,"","",0);
        listOfOperationsEN2.add(op1);
        listOfOperationsEN2.add(op2);
        listOfOperationsEN2.add(op3);
        listOfOperationsEN2.add(op4);
        listOfOperationsEN2.add(op5);
        listOfOperationsEN2.add(op6);
        listOfOperationsEN2.add(op7);
        listOfOperationsEN2.add(op8);
        listOfOperationsEN2.add(op9);
        listOfOperationsEN2.add(op10);
        listOfOperationsEN2.add(op11);
        listOfOperationsEN2.add(op12);
        listOfOperationsEN2.add(op13);
        listOfOperationsEN2.add(op14);
        listOfOperationsEN2.add(op15);
    }
    
    public void loadThreadEX1Data()
    {
        Operation op1 = new Operation(4,"","",0);
        Operation op2 = new Operation(7,"","2022/07/12-11:24:34",0);
        Operation op3 = new Operation(7,"","2022/07/12-11:14:34",0);
        Operation op4 = new Operation(5,"","",0);
        Operation op5 = new Operation(7,"","2022/07/12-15:34:34",0);
        Operation op6 = new Operation(8,"","2022/07/12-16:34:34",0);
        Operation op7 = new Operation(1,"WP1234","2022/07/12-12:34:34",1);
        Operation op8 = new Operation(1,"WP1235","2022/07/12-13:34:34",2);
        Operation op9 = new Operation(1,"WP1236","2022/07/12-14:34:34",3);
        Operation op10 = new Operation(3,"","",0);
        Operation op11 = new Operation(5,"","",0);
        Operation op12 = new Operation(1,"NP1237","2022/07/12-17:34:34",4);
        Operation op13 = new Operation(1,"NP1238","2022/07/12-16:34:34",5);
        Operation op14 = new Operation(1,"NP1239","2022/07/12-15:34:34",6);
        Operation op15 = new Operation(1,"NP1230","2022/07/13-12:24:34",7);
        
        listOfOperationsEX1.add(op1);
        listOfOperationsEX1.add(op2);
        listOfOperationsEX1.add(op3);
        listOfOperationsEX1.add(op4);
        listOfOperationsEX1.add(op5);
        listOfOperationsEX1.add(op6);
        listOfOperationsEX1.add(op7);
        listOfOperationsEX1.add(op8);
        listOfOperationsEX1.add(op9);
        listOfOperationsEX1.add(op10);
        listOfOperationsEX1.add(op11);
        listOfOperationsEX1.add(op12);
        listOfOperationsEX1.add(op13);
        listOfOperationsEX1.add(op14);
        listOfOperationsEX1.add(op15);
        
    }
    
    public void loadThreadEX2Data()
    {
        Operation op1 = new Operation(4,"","",0);
        Operation op2 = new Operation(7,"","2022/07/12-11:24:34",0);
        Operation op3 = new Operation(7,"","2022/07/12-11:14:34",0);
        Operation op4 = new Operation(5,"","",0);
        Operation op5 = new Operation(7,"","2022/07/12-15:34:34",0);
        Operation op6 = new Operation(8,"","2022/07/12-16:34:34",0);
        Operation op7 = new Operation(1,"NP1234","2022/07/12-12:34:34",1);
        Operation op8 = new Operation(1,"NP1235","2022/07/12-13:34:34",2);
        Operation op9 = new Operation(1,"NP1236","2022/07/12-14:34:34",3);
        Operation op10 = new Operation(3,"","",0);
        Operation op11 = new Operation(5,"","",0);
        Operation op12 = new Operation(1,"WP1237","2022/07/12-17:34:34",4);
        Operation op13 = new Operation(1,"WP1238","2022/07/12-16:34:34",5);
        Operation op14 = new Operation(1,"WP1239","2022/07/12-15:34:34",6);
        Operation op15 = new Operation(1,"WP1230","2022/07/13-12:24:34",7);
        
        listOfOperationsEX2.add(op1);
        listOfOperationsEX2.add(op2);
        listOfOperationsEX2.add(op3);
        listOfOperationsEX2.add(op4);
        listOfOperationsEX2.add(op5);
        listOfOperationsEX2.add(op6);
        listOfOperationsEX2.add(op7);
        listOfOperationsEX2.add(op8);
        listOfOperationsEX2.add(op9);
        listOfOperationsEX2.add(op10);
        listOfOperationsEX2.add(op11);
        listOfOperationsEX2.add(op12);
        listOfOperationsEX2.add(op13);
        listOfOperationsEX2.add(op14);
        listOfOperationsEX2.add(op15);
    }
    
    public ArrayList<Operation> getEN1TestData()
    {
        return listOfOperationsEN1;    
    }
    
    public ArrayList<Operation> getEN2TestData()
    {
        return listOfOperationsEN2; 
    }
    
    public ArrayList<Operation> getEX1TestData()
    {
        return listOfOperationsEX1; 
    }
    
    public ArrayList<Operation> getEX2TestData()
    {
        return listOfOperationsEX2; 
    }
}
