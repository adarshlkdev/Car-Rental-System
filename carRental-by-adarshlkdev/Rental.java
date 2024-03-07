package com.company.carRental;

public class Rental {
    private Car car;
    private Customer customer;
    private int days;

    public Rental(Car car , Customer customer , int days){
        this.car = car;
        this.customer = customer;
        this.days = days;
    }

    public Car getCar() {
        return car;
    }

    public Customer getCustomer() {
        return customer;
    }

    public int getDays() {
        return days;
    }
}
