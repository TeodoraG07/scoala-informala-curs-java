package ro.scoala_informala;


import java.util.ArrayList;
import java.util.List;

public class ApplicationTask3 {
    public static void main(String[] args) {
        int a = 3456;
        List<Integer> digits = new ArrayList<>();
        while (a > 0) {
            int digit = a % 10;
            digits.add(0, digit);
            a = a / 10;

        }
        int largest = digits.size();
        for (int i = 0; i < digits.size(); i++) {
            System.out.println(i);
            if (digits.get(i) >= largest) {
                largest = digits.get(i);
            }
        }
        System.out.println("Largest value: " + largest);
    }
}


