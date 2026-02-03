package ro.scoala_informala;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class PackageManagement {

    private static final int PRICE_PER_KM = 1;

    public void process(List<DeliveryPackage> packages) throws InterruptedException {

        Map<String, Map<LocalDate, List<DeliveryPackage>>> grouped =
                packages.stream()
                        .collect(Collectors.groupingBy(
                                DeliveryPackage::getLocation,
                                Collectors.groupingBy(DeliveryPackage::getDate)
                        ));

        List<Thread> threads = new ArrayList<>();

        AtomicInteger totalValue = new AtomicInteger();
        AtomicInteger totalRevenue = new AtomicInteger();

        for (var locationEntry : grouped.entrySet()) {
            for (var dateEntry : locationEntry.getValue().entrySet()) {

                List<DeliveryPackage> groupPackages = dateEntry.getValue();

                totalValue.addAndGet(
                        (int) groupPackages.stream().mapToDouble(DeliveryPackage::getPrice).sum()
                );

                float distance = (float) groupPackages.get(0).getDistanceKm();
                totalRevenue.addAndGet((int) (distance * PRICE_PER_KM));

                Thread thread = new Thread(
                        new DeliveryTask(locationEntry.getKey(), dateEntry.getKey(), groupPackages)
                );

                threads.add(thread);
                thread.start();
            }
        }
        for (Thread t : threads) {
            t.join();
        }

        System.out.println("\n==== FINAL RESULT ====");
        System.out.println("Total package value: " + totalValue.get());
        System.out.println("Total revenue: " + totalRevenue.get());
    }
}
