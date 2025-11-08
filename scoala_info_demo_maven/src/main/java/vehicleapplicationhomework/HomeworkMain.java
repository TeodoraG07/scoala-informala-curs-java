package vehicleapplicationhomework;

public class HomeworkMain {
    public static void main(String[] args) {

//        Car car = new Car(); // this should not compile.
//
//        Car car = new Dacia(27, "oiqe0934hkkadsn"); // this should not compile! If I want to create a Dacia car, I will need to create an instance of a Dacia model.

//        Car car = new Logan(27, "oiqe0934hkkadsn"); // Logan can extend from Dacia, while Dacia extends from Car
//        car.start();
//
//        car.shiftGear(1);
//
//        car.drive(0.01f); // drives 0.01 KMs
//
//        car.shiftGear(2);
//
//        car.drive(0.02f);
//
//        car.shiftGear(3);
//
//        car.drive(0.5f);
//
//        car.shiftGear(4);
//
//        car.drive(0.5f);
//
//        car.shiftGear(4);
//
//        car.drive(0.5f);
//
//        car.shiftGear(5);
//
//        car.drive(10f);
//
//        car.shiftGear(4);
//
//        car.drive(0.5f);
//
//        car.shiftGear(3);
//
//        car.drive(0.1f);
//
//        car.stop();
//
//        float availableFuel = car.getAvailableFuel();
//
//        float fuelConsumedPer100Km = car.getAverageFuelConsumption();
//
        Vehicle vehicle = new VWGolf(30, "1987ddkshik289"); // available fuel and chassis number

        vehicle.start();

        vehicle.drive(1f);

        vehicle.shiftGear(7); //Teodora - I added the shiftGear in order to make sure that a result is displayed for the code lines below. (shiftgear is the method that does the calculation in my case)

        vehicle.stop();


        Car car = (Car) vehicle;

        float availableFuel = car.getAvailableFuel();

        float fuelConsumedPer100Km = car.getAverageFuelConsumption();
    }
}