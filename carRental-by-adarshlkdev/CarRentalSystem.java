package com.company.carRental;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CarRentalSystem {
    private List<Car> cars;
    private List<Customer> customers;
    private List<Rental> rentals;

    public CarRentalSystem(){
        cars = new ArrayList<>();
        customers = new ArrayList<>();
        rentals = new ArrayList<>();
    }

    public void addCar(Car car){
        cars.add(car);
    }
    public void addCustomer(Customer customer){
        customers.add(customer);
    }
    public void rentCar(Car car , Customer customer , int days){
        if(car.isAvaliable()){
            car.rent();
            rentals.add(new Rental(car , customer , days));
        }
        else{
            System.out.println("Car is not avaliable for rent");
        }
    }

    public void returnCar(Car car){
        car.returnCar();
        Rental rentalToRemove= null;
        for(Rental rental : rentals){
            if(rental.getCar() == car){
                rentalToRemove = rental;
                break;
            }
        }

        if(rentalToRemove != null){
            rentals.remove(rentalToRemove);
        }
        else{
            System.out.println("Car was not rented");
        }
    }

    public void menu(){
        Scanner sc = new Scanner(System.in);

        while(true){
            System.out.println("==== Car Rental System ====");
            System.out.println("1. Rent a Car");
            System.out.println("2. Return a car");
            System.out.println("3. Exit");
            System.out.println("Enter your choice : ");

            int choice = sc.nextInt();
            sc.nextLine();

            if(choice==1){


                System.out.println("\n== Rent a car ==\n");
                System.out.println("Enter your name: ");
                String customerName = sc.nextLine();


                System.out.println("\nAvaliable cars: ");
                for(Car car: cars){
                    if(car.isAvaliable()){
                        System.out.println(car.getCarId() + "  -  " + car.getBrand() + "  -  " + car.getModel());

                    }
                }

                System.out.println("\n Enter the car id you want to rent : ");
                String carId = sc.nextLine();

                System.out.println("Enter the number of days of rental : ");
                int rentalDays = sc.nextInt();
                sc.nextLine();

                Customer newCustomer = new Customer("CUS" + (customers.size() + 1) , customerName);
                addCustomer(newCustomer);

                Car selectedCar = null;
                for(Car car: cars){
                    if(car.getCarId().equals(carId) && car.isAvaliable()){
                        selectedCar = car;
                        break;
                    }
                }

                if(selectedCar != null){
                    double totalPrice = selectedCar.calculatePrice(rentalDays);
                    System.out.println("\n==  Rental Information ==\n");
                    System.out.println("Customer ID: "+newCustomer.getCustomerId());
                    System.out.println("Customer Name: "+newCustomer.getName());
                    System.out.println("Car :"+ selectedCar.getBrand()+" "+ selectedCar.getModel());
                    System.out.println("Rental Days : "+rentalDays);
                    System.out.println("Total Price : " +totalPrice);


                    System.out.println("\nConfirm Rental (Y/N) :");
                    String confirm = sc.nextLine();

                    if(confirm.equalsIgnoreCase("Y")){
                        rentCar(selectedCar , newCustomer , rentalDays);
                        System.out.println("\nCar rented successfully");
                    }
                    else{
                        System.out.println("Rental Cancelled");
                    }


                }


            }



            else if(choice == 2){


                System.out.println("\n== Return a car ==\n");
                System.out.println("Enter your car id if you want to return: ");
                String carId = sc.nextLine();

                Car carToReturn = null;
                for(Car car : cars){
                    if(car.getCarId().equals(carId) && !car.isAvaliable()){
                        carToReturn = car;
                        break;
                    }
                }

                if(carToReturn != null){
                    Customer customer = null;
                    for(Rental rental : rentals){
                        if(rental.getCar() == carToReturn){
                            customer = rental.getCustomer();
                            break;
                        }
                    }

                    if(customer != null){
                         returnCar(carToReturn);
                        System.out.println("Car returned successfully by " + customer.getName());
                    }
                    else{
                        System.out.println("Car was not rented or rental information is missing");
                    }

                }
                else{
                    System.out.println("Invalid car id or car is not rented");
                }
            }



            else if(choice == 3){
                break;
            }else{
                System.out.println("Invalid Choice. Please enter a valid option");
            }
        }
        System.out.println("Thank for your using our Car Rental System");
    }

}
