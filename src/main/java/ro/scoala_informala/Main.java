package ro.scoala_informala;


import java.util.List;

public class Main {
    public static void main(String[] args) {

        AthletesCsvReader reader = new AthletesCsvReader();
        List<Athletes> athletes = reader.readAthletes();

//        for (Athletes athlete : athletes) {
//            System.out.println(athlete);


        for (Athletes athlete : athletes) {
            System.out.println(
                    athlete.getName() + " " + athlete.finalTimeSeconds()
            );
        }
    }
}
