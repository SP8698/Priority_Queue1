package com.Vehicle;

public class ElectricCar extends Car {
    private int batteryCapacity;
    private int range;

    public ElectricCar(String color, String make, String model, int year, int numDoors, String transmissionType, int batteryCapacity, int range) {
        super(color, make, model, year, numDoors, transmissionType);
        this.batteryCapacity = batteryCapacity;
        this.range = range;
    }

    public int getBatteryCapacity() {
        return batteryCapacity;
    }

    public void setBatteryCapacity(int batteryCapacity) {
        this.batteryCapacity = batteryCapacity;
    }

    public int getRange() {
        return range;
    }

    public void setRange(int range) {
        this.range = range;
    }


    public void displayInfo() {
        super.displayInfo();
        System.out.println("Battery Capacity: " + batteryCapacity + " kWh, Range: " + range + " miles");
    }
}

