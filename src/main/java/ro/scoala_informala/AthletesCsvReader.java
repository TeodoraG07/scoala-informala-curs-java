package ro.scoala_informala;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

public class AthletesCsvReader {
    public List<Athletes> parse(String csvContent) {
        List<Athletes> athletes = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new StringReader(csvContent))) {
            String line;
            boolean firstLine = true;
            while ((line = br.readLine()) != null) {
                if (firstLine) {
                    firstLine = false;
                    continue;
                }

                line = line.replace("\"", "");
                String[] parts = line.split(",");

                int id = Integer.parseInt(parts[0].trim());
                String name = parts[1].trim();
                Athletes.Country country = Athletes.Country.valueOf(parts[2].trim());
                int skiTimeInSeconds = parseSkiTimeToSeconds(parts[3].trim());
                int firstShootingRange = calculateShootingScore(parts[4].trim());
                int secondShootingRange = calculateShootingScore(parts[5].trim());
                int thirdShootingRange = calculateShootingScore(parts[6].trim());

                athletes.add(new Athletes(
                        id,
                        name,
                        country,
                        skiTimeInSeconds,
                        firstShootingRange,
                        secondShootingRange,
                        thirdShootingRange
                ));
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return athletes;
    }

    private int calculateShootingScore(String pattern) {
        int score = 0;
        for (char c : pattern.toCharArray()) {
            if (c == 'o') {
                score += 10;
            } else if (c == 'x') {
                score += 0;
            } else {
                throw new IllegalArgumentException(
                        "Invalid shooting character: " + c
                );
            }
        }
        return score;
    }

    private int parseSkiTimeToSeconds(String time) {
        String[] t = time.split(":");
        int minutes = Integer.parseInt(t[0]);
        int seconds = Integer.parseInt(t[1]);
        return minutes * 60 + seconds;
    }
}




