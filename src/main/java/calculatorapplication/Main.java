package calculatorapplication;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter expression: ");
        String input = scanner.nextLine();

        Calculator calculator = new Calculator();
        calculator.processCalculation(input);
    }
}