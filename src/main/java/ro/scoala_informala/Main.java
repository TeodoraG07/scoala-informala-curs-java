package ro.scoala_informala;

import java.io.BufferedReader;
import java.io.StringReader;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        CsvFileLoader csvreader = new CsvFileLoader();
        String csvContent =  csvreader.readCsvFile("Athletes.csv");
        AthletesCsvReader  athletesreader = new AthletesCsvReader();
        List <Athletes> athletes= athletesreader.parse(csvContent);
        sortAthletesByTime(athletes);
    }

    private static void sortAthletesByTime(List<Athletes> athletes) {
        athletes.sort(Comparator.comparingInt(Athletes::finalTimeSeconds));
        int rank = 1;
        for (Athletes athlete : athletes) {
            System.out.println(
                    rank++ + ". " +
                            athlete.getName() + " " +
                            athlete.finalTimeSeconds());

        }
    }
}

