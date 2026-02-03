package ro.scoala_informala;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ReadFile {
    public List<DeliveryPackage> readPackage(String PackageData) {
        List<DeliveryPackage> packages = new ArrayList<>();
        InputStream inputStream =
                getClass().getClassLoader().getResourceAsStream(PackageData);
        if (inputStream == null) {
            throw new RuntimeException("File not found: " + inputStream);
        }
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");

                String location = parts[0];
                float distanceKm = Float.parseFloat(parts[1]);
                float price = Float.parseFloat(parts[2]);
                LocalDate date = LocalDate.parse(parts[3]);
                packages.add(new DeliveryPackage(location, distanceKm, price, date));
            }
        } catch (Exception e) {
            throw new RuntimeException("Error reading file", e);
        }
        return packages;
    }
}

