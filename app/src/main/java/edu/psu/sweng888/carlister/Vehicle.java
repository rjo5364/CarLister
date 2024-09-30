package edu.psu.sweng888.carlister;

import java.io.Serializable;

public class Vehicle implements Serializable{
    private String name;
    private String manufacturer;
    private int year;
    private int mileage;
    private String condition;
    private String color;
    private int imageResourceId;

    // Class Contstructor
    public Vehicle(String name, String manufacturer, int year, int mileage, String condition, String color, int imageResourceId) {
        this.name = name;
        this.manufacturer = manufacturer;
        this.year = year;
        this.mileage = mileage;
        this.condition = condition;
        this.color = color;
        this.imageResourceId = imageResourceId;
    }

    // setting up getters
    public String getName() {
        return name;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public int getYear() {
        return year;
    }

    public int getMileage() {
        return mileage;
    }

    public String getCondition() {
        return condition;
    }

    public String getColor() {
        return color;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }

    // Initializing setters for each parameter
    public void setName(String name) {
        this.name = name;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setImageResourceId(int imageResourceId) {
        this.imageResourceId = imageResourceId;
    }
}


