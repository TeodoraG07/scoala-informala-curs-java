package ro.scoala_informala;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class AthletesCsvReader {
    public List<Athletes> readAthletes() {
        String path = "Athletes.csv";
        List<Athletes> athletes = new ArrayList<Athletes>();

        try (BufferedReader br = new BufferedReader(new InputStreamReader(
                Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("Athletes.csv")),
                StandardCharsets.UTF_8))) {
            String line;
            boolean firstLine = true;
            while ((line = br.readLine()) != null) {
                if (firstLine) {
                    firstLine = false;
                    continue;
                }

                line = line.replace("\"", "");

                String[] parts = line.split(",");
                int id = Integer.parseInt(parts[0]);
                String name = parts[1];
                Athletes.Country country = Athletes.Country.valueOf(parts[2].trim());

                int skiTimeInSeconds =
                        parseSkiTimeToSeconds(parts[3]);

                int firstShootingRange =
                        calculateShootingScore(parts[4]);
                int secondShootingRange =
                        calculateShootingScore(parts[5]);
                int thirdShootingRange =
                        calculateShootingScore(parts[6]);

                Athletes athlete = new Athletes(
                        id,
                        name,
                        country,
                        skiTimeInSeconds,
                        firstShootingRange,
                        secondShootingRange,
                        thirdShootingRange
                );

                athletes.add(athlete);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return athletes;
    }

    private int calculateShootingScore(String pattern) {
        int score = 0;
        for (char c : pattern.toCharArray()) {
            if (c == 'x') {
                score += 10;
            } else if (c == 'o') {
                score += 0;
            } else {
                throw new IllegalArgumentException("Invalid shooting character: " + c);
            }
        }
        return score;
    }


    private int parseSkiTimeToSeconds(String time) {
        String[] t = time.split(":");
        int minutes = Integer.parseInt(t[0]);
        int seconds = Integer.parseInt(t[1]);
        int hundredths = Integer.parseInt(t[2]);

        return minutes * 60 + seconds;
    }
}



