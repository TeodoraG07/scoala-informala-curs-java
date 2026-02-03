package ro.scoala_informala;

import java.time.LocalDate;

public class DeliveryPackage {
    private String location;
    private float distanceKm;
    private float price;
    private LocalDate date;

    public DeliveryPackage(String location, float distanceKm, float price, LocalDate date) {
        this.location = location;
        this.distanceKm = distanceKm;
        this.price = price;
        this.date = date;

    }

    public String getLocation() {
        return location;
    }

    public float getDistanceKm() {
        return distanceKm;
    }

    public float getPrice() {
        return price;
    }

    public LocalDate getDate() {
        return date;
    }

}
