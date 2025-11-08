package vehicleapplicationhomework;

import java.util.ArrayList;

public abstract class Car implements Vehicle {
    protected final int fuelTankSize;
    protected final String fuelType;
    protected final int gears;
    protected final float consumptionPer100Km;
    protected float availableFuel;
    protected int tireSize;
    protected String chassisNumber;
    float distance;
    protected final ArrayList<Float> consumptionPer100Kmhistory = new ArrayList<>();

    public Car(int fuelTankSize,
               String fuelType,
               int gears,
               float consumptionPer100Km,
               float availableFuel,
               int tireSize,
               String chassisNumber) {
        this.fuelTankSize = fuelTankSize;
        this.fuelType = fuelType;
        this.gears = gears;
        this.consumptionPer100Km = consumptionPer100Km;
        this.availableFuel = availableFuel;
        this.tireSize = tireSize;
        this.chassisNumber = chassisNumber;
    }


    @Override
    public void start() {
        System.out.println("Dacia is starting...");

    }

    @Override
    public void stop() {
        System.out.println("Car stopping...");

    }

    private void setAvailableFuel(float newAvailableFuel) {
        this.availableFuel = newAvailableFuel;
        System.out.println("Available fuel set to: " + availableFuel);
    }

    public float getAvailableFuel() {
        return availableFuel;
    }

    @Override
    public void drive(float distance) {
        System.out.println("Driving " + distance + " km");
        this.distance = distance;
        float currentFuel = getAvailableFuel();
        float currentConsumptionPer100Km = getConsumptionPer100Km();
        float newAvailableFuel = (currentFuel - (distance * currentConsumptionPer100Km) / 100);

        setAvailableFuel(newAvailableFuel);
        System.out.println("This is the available fuel " + newAvailableFuel);
    }

    public int shiftGear(int newGear) {
        int currentGear = getGear();
        float currentConsumptionPer100k = getConsumptionPer100Km();
        float newConsumptionPer100km = currentConsumptionPer100k;
        if (newGear > currentGear && tireSize <= 10) {
            newConsumptionPer100km = currentConsumptionPer100k - (currentConsumptionPer100k * 0.10f);
        } else if (newGear > currentGear && tireSize > 10) {
            newConsumptionPer100km = currentConsumptionPer100k - (currentConsumptionPer100k * 0.8f);
        } else if (newGear == currentGear && tireSize == 10) {
            newConsumptionPer100km = currentConsumptionPer100k;
        } else if (newGear < currentGear && tireSize <= 10) {
            newConsumptionPer100km = currentConsumptionPer100k + (currentConsumptionPer100k * 0.10f);
        } else if (newGear < currentGear && tireSize > 10) {
            newConsumptionPer100km = currentConsumptionPer100k + (currentConsumptionPer100k * 0.12f);
        } else {
            System.out.println("Apologies, I don't know to calculate!");

        }
        System.out.println("New Gear is " + newGear);
        consumptionPer100Kmhistory.add(newConsumptionPer100km);
        System.out.println(consumptionPer100Kmhistory);
        return currentGear;
    }

    int getGear() {
        return gears;
    }

    float getAverageFuelConsumption() {
        float sum = 0;
        for (Float value : consumptionPer100Kmhistory) {
            sum += value;
        }

        float average = sum / consumptionPer100Kmhistory.size();
        System.out.println("The average consumption for 100 ok is:  " + average);
        return average;
    }


    float getConsumptionPer100Km() {
        return (float) consumptionPer100Km;
    }
}


