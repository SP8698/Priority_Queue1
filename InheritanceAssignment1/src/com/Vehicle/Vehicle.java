package com.Vehicle;

public class Vehicle {
    private String color;
    private String make;
    private String model;
    private int year;

    public Vehicle(String color, String make, String model, int year) {
        this.color = color;
        this.make = make;
        this.model = model;
        this.year = year;
    }

  
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void displayInfo() {
        System.out.println("Vehicle Info: " + make + " " + model + ", Year: " + year + ", Color: " + color);
    }
}

