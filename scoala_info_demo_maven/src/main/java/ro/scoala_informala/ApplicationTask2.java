package ro.scoala_informala;

public class ApplicationTask2 {
    public static void main(String[] args) {
        int a=3;
        int b=8;
        int[] c = new int [b - a + 1];
        for (int index = 0; index < c.length; index++) {
            c[index] =a+index;
        }
        int smallest = c[0];
        for (int i = 0; i < c.length; i++) {
            System.out.println(i);
            if (c[i] <= smallest) {
                smallest = c[i];
            }
        }
        System.out.println("Smallest value: " + smallest);


    }
}

