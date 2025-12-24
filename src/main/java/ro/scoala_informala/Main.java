package ro.scoala_informala;

import java.io.BufferedReader;
import java.io.StringReader;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        AthletesCsvReader reader = new AthletesCsvReader();
        String path = "Athletes.csv";
        List<Athletes> athletes = reader.readAthletes(new BufferedReader(new StringReader(path)));

//        for (Athletes athlete : athletes) {
//            System.out.println(athlete);

        for (Athletes athlete : athletes) {
            System.out.println(
                    athlete.getName() + " " + athlete.finalTimeSeconds()
            );
        }
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
