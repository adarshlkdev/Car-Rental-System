package com.company.carRental;

public class Main {
    public static void main(String[] args) {
        CarRentalSystem rentalSystem = new CarRentalSystem();

        Car car1 = new Car("C001" , "Toyota" , "Camry" , 50);
        Car car2 = new Car("C002" , "Mahindra" , "Thar" , 20);
        Car car3 = new Car("C003" , "KIA" , "Seltos" , 40);
       rentalSystem.addCar(car1);
       rentalSystem.addCar(car2);
        rentalSystem.addCar(car3);
       rentalSystem.menu();
    }

}