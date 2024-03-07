package com.company.carRental;


public class Car {
    private String carId;
    private String brand;
    private String model;
    private double basePricePerDay;
    private boolean isAvaliable;

    public Car(String carId , String brand , String model , double basePricePerDay){
        this.carId = carId;
        this.brand = brand;
        this.model = model;
        this.basePricePerDay = basePricePerDay;
        this.isAvaliable = true;
    }

    public String getCarId(){
        return carId;
    }
    public String getBrand(){
        return brand;
    }
    public String getModel(){
        return model;
    }

    public double calculatePrice(int rentalDays){
        return basePricePerDay * rentalDays;
    }
    public boolean isAvaliable(){
        return isAvaliable;
    }

    public void rent(){
        isAvaliable = false;
    }
    public void returnCar(){
        isAvaliable = true;
    }

}
