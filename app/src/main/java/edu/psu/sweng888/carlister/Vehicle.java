package edu.psu.sweng888.carlister;
import java.io.Serializable;

// The vehicle class is a vehicle object with details such as name, manufacturer, year, mileage and implements Serializable to allow Vehicle objects to be passed between activities as Intent extras.
public class Vehicle implements Serializable {
    // Defining properties of the vehicle

    private String name;
    private String manufacturer;
    private int year;
    private int mileage;
    private String condition;
    private String color;
    private int imageResourceId;

    // Constructor
    public Vehicle(String name, String manufacturer, int year, int mileage, String condition, String color, int imageResourceId) {
        // Constructor to initialize a Vehicle object with the provided parameters

        this.name = name;
        this.manufacturer = manufacturer;
        this.year = year;
        this.mileage = mileage;
        this.condition = condition;
        this.color = color;
        this.imageResourceId = imageResourceId;
    }

    // Getters
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
}
