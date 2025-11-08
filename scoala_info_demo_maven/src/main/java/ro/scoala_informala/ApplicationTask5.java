package ro.scoala_informala;

import java.util.Scanner;


public class ApplicationTask5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Give me a number ;): ");
        int a = scanner.nextInt();
        while (a<0) {
            System.out.println("Enter a positive number: ");
            a = scanner.nextInt();
        }
        {System.out.println("Congrats! You entered a positive number: "+a);}
        int[] b = new int[a + 1];
        for (int index = 0; index < b.length; index++) {
                b[index] = a - index;
            }
           // System.out.println(Arrays.toString(b));
        for (int i = 0; i < b.length; i++){
        if (b[i] % 2 == 0) {
            System.out.println("Even number: " + b[i]);
        }
    }}}






