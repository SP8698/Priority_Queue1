package com.Vehicle;

public class VehicleDemonstration {

	public static void main(String[] args) {
		Vehicle vehicle = new Vehicle("Red", "Generic", "Model", 2020);
        vehicle.displayInfo();

        Car car = new Car("White", "Suzuki", "Camry", 2018, 4, "Manual");
        car.displayInfo();

        Truck truck = new Truck("Black", "Ford", "F-150", 2019, 5.5, 13000);
        truck.displayInfo();

        ElectricCar electricCar = new ElectricCar("White", "Tesla", "Model S", 2022, 4, "Automatic", 100, 300);
        electricCar.displayInfo();

        GasolineCar gasolineCar = new GasolineCar("Silver", "Honda", "Accord", 2018, 4, "Manual", 14, 30);
        gasolineCar.displayInfo();

	}

}
