package ro.scoala_informala;

import java.util.List;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        ReadFile reader = new ReadFile();
        List<DeliveryPackage> packages = reader.readPackage("PackageData.txt");
        PackageManagement management = new PackageManagement();
        management.process(packages);
    }
}