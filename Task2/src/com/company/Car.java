package com.company;

public class Car {
    private String model;
    private int year;
    private double engineCapacity;

    Car() {
        this.model = "BMW X5";
        this.year = 1999;
        this.engineCapacity = 3;
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

    public double getEngineCapacity() {
        return engineCapacity;
    }

    public void setEngineCapacity(double engineCapacity) {
        this.engineCapacity = engineCapacity;
    }

    public Car(String model, int year, double engineCapacity) {
        this.model = model;
        this.year = year;
        this.engineCapacity = engineCapacity;
    }

    public void print() {
        System.out.println(String.format("%s, %d year", this.model, this.year));
    }
}
