package vehicleapplicationhomework;

import java.util.ArrayList;
import java.util.List;

public class MyMain {
    public static void main(String[] args) {
        List<Mercedes> mercedes = new ArrayList<Mercedes>();
        Mercedes mercedes1 = new Mercedes("CKlasse", 9, "Diesel", 6, 10.2f, 10, 8, "07.IamtheBoss");
//        Mercedes mercedes2 = new Mercedes("SKlasse", "small", "Diesel", 8, 2.3f, 8, 10, "05.IamtheQueen");
        mercedes.add(mercedes1);
        //      mercedes.add(mercedes2);
        mercedes1.start();
        mercedes1.shiftGear(7);
        mercedes1.drive(45);
        mercedes1.shiftGear(8);
        mercedes1.drive(55);
        mercedes1.stop();

    }
}


