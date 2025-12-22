package calculatorapplication;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Calculator {

    private List<String> tokenize(String expr) {
        return new ArrayList<>(Arrays.asList(expr.split(" ")));
    }

    public int processCalculation(String expression) {
        List<String> tokens = tokenize(expression);
        System.out.println("Tokens: " + tokens);

        for (int i = 0; i < tokens.size(); i += 3) {
            int value = Integer.parseInt(tokens.get(i));
            String unit = tokens.get(i + 1);
            String operator = (i + 2 < tokens.size()) ? tokens.get(i + 2) : null;
        }

        List<String> units = new ArrayList<>();
        for (int i = 0; i < tokens.size(); i += 3) {
            units.add(tokens.get(i + 1));
        }


        String lowest = findLowestUnit(units);
        System.out.println("Lowest unit: " + lowest);

        int result = calculate(expression, lowest);

        System.out.println("Result = " + result + " " + lowest);
        return result;
    }

    public int unitRank(String metric) {
        if (metric.equals("mm")) return 0;
        if (metric.equals("cm")) return 1;
        if (metric.equals("dm")) return 2;
        if (metric.equals("m")) return 3;
        if (metric.equals("km")) return 4;
        else return -1;
    }

    private String findLowestUnit(List<String> units) {
        String lowest = units.get(0);
        for (String metric : units) {
            if (unitRank(metric) < unitRank(lowest)) {
                lowest = metric;
            }
        }
        return lowest;
    }

    private int convertTo(String unit, int value, String lowestUnit) {
        // convert input to mm
        int mm;
        if (unit.equals("mm")) mm = value;
        else if (unit.equals("cm")) mm = value * 10;
        else if (unit.equals("dm")) mm = value * 100;
        else if (unit.equals("m")) mm = value * 1000;
        else if (unit.equals("km")) mm = value * 1_000_000;
        else return -1;


        int mmPerLowest;
        if (lowestUnit.equals("mm")) mmPerLowest = 1;
        else if (lowestUnit.equals("cm")) mmPerLowest = 10;
        else if (lowestUnit.equals("dm")) mmPerLowest = 100;
        else if (lowestUnit.equals("m")) mmPerLowest = 1000;
        else if (lowestUnit.equals("km")) mmPerLowest = 1_000_000;
        else throw new IllegalArgumentException("Unknown unit: " + lowestUnit);

        return mm / mmPerLowest;
    }


    public int calculate(String expression, String lowestUnit) {
        List<String> tokens = tokenize(expression);

        int result = 0;
        String op = "+";

        for (int i = 0; i < tokens.size(); i += 3) {

            int value = Integer.parseInt(tokens.get(i));
            String unit = tokens.get(i + 1);

            int normalized = convertTo(unit, value, lowestUnit);

            if (op.equals("+")) {
                result += normalized;
            } else if (op.equals("-")) {
                result -= normalized;
            } else {
                throw new IllegalArgumentException("Unknown operator: " + op);
            }


            if (i + 2 < tokens.size()) {
                String nextOp = tokens.get(i + 2);

                if (!nextOp.equals("+") && !nextOp.equals("-")) {
                    throw new IllegalArgumentException("Unknown operator: " + nextOp);

                }

                op = nextOp;
            }
        }

        return result;
    }
}
