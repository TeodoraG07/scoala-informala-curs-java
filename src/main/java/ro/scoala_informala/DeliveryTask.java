package ro.scoala_informala;

import java.time.LocalDate;
import java.util.List;

public class DeliveryTask implements Runnable {

    private final String location;
    private final LocalDate date;
    private final List<DeliveryPackage> packages;

    public DeliveryTask(String location, LocalDate date, List<DeliveryPackage> packages) {
        this.location = location;
        this.date = date;
        this.packages = packages;
    }

    @Override
    public void run() {
        float distanceKm = packages.get(0).getDistanceKm();
        float groupPrice = (float) packages.stream().mapToDouble(DeliveryPackage::getPrice).sum();
        float revenue = distanceKm;

        try {
            Thread.sleep((long) (distanceKm * 1000L));
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.println(
                "[Delivering for <" + location + "> and date <" + date +
                        "> in <" + distanceKm + "> seconds] | Group value: " +
                        groupPrice + " | Revenue: " + revenue
        );
    }
}

