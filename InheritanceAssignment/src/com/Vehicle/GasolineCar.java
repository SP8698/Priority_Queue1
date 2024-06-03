package com.Vehicle;

public class GasolineCar extends Car {
    private int fuelCapacity;
    private int mpg;

    public GasolineCar(String color, String make, String model, int year, int numDoors, String transmissionType, int fuelCapacity, int mpg) {
        super(color, make, model, year, numDoors, transmissionType);
        this.fuelCapacity = fuelCapacity;
        this.mpg = mpg;
    }

    
    public int getFuelCapacity() {
        return fuelCapacity;
    }

    public void setFuelCapacity(int fuelCapacity) {
        this.fuelCapacity = fuelCapacity;
    }

    public int getMpg() {
        return mpg;
    }

    public void setMpg(int mpg) {
        this.mpg = mpg;
    }

    public void displayInfo() {
        super.displayInfo();
        System.out.println("Fuel Capacity: " + fuelCapacity + " gallons, MPG: " + mpg);
    }
}

