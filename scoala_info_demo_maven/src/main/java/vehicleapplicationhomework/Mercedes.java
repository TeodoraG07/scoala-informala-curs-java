package vehicleapplicationhomework;

public class Mercedes extends Car implements Vehicle {
    protected String model;

    public Mercedes(String model,
                    int fuelTankSize,
                    String fuelType,
                    int gears,
                    float consumptionPer100Km,
                    float availableFuel,
                    int tireSize,
                    String chassisNumberString) {
        super(fuelTankSize, fuelType, gears, consumptionPer100Km, availableFuel, tireSize, chassisNumberString);
        this.model = model;
    }

    @Override
    public void start() {
        System.out.println("Mercedes is starting...");

    }

    @Override
    public void stop() {
        System.out.println("Mercedes is stopping...");

    }

    private void setAvailableFuel(float newAvailableFuel) {
        this.availableFuel = newAvailableFuel;
        System.out.println("Available fuel set to: " + availableFuel);
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
        System.out.println("This is the consumption per 100 km until now" + consumptionPer100Kmhistory);
        return currentGear;
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

}


