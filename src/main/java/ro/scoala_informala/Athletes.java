package ro.scoala_informala;

public class Athletes {
    protected int id;
    private String name;
    Country country;
    private int skiTimeInSeconds;
    private int firstShootingRange;
    private int secondShootingRange;
    private int thirdShootingRange;


    public Athletes(int id, String name, Country country, int skiTimeInSeconds, int firstShootingRange, int secondShootingRange, int thirdShootingRange) {
        this.id = id;
        this.name = name;
        this.country = country;
        this.skiTimeInSeconds = skiTimeInSeconds;
        this.firstShootingRange = firstShootingRange;
        this.secondShootingRange = secondShootingRange;
        this.thirdShootingRange = thirdShootingRange;
    }

    public enum Country {
        RO, UK, SK, CZ, PL, TR, USA
    }

    private Country parseCountry(String value) {
        try {
            return Country.valueOf(value.trim());
        } catch (IllegalArgumentException e) {
            throw new RuntimeException("Invalid country in CSV: " + value);
        }
    }

    @Override
    public String toString() {
        return "Athletes{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", country='" + country + '\'' +
                ", skiTimeInSeconds=" + skiTimeInSeconds +
                ", firstShootingRange=" + firstShootingRange +
                ", secondShootingRange=" + secondShootingRange +
                ", thirdShootingRange=" + thirdShootingRange +
                '}';
    }

    public int finalTimeSeconds() {
        return (int) (skiTimeInSeconds
                + firstShootingRange
                + secondShootingRange
                + thirdShootingRange);
    }

    public String getName() {
        return name;
    }

    public Country getCountry() {
        return country;
    }

    public int getId() {
        return id;
    }

    public int getSkiTimeInSeconds() {
        return skiTimeInSeconds;
    }

    public int getFirstShootingRange() {
        return firstShootingRange;
    }

    public int getSecondShootingRange() {
        return secondShootingRange;
    }

    public int getThirdShootingRange() {
        return thirdShootingRange;
    }

    public int calculateShootingScore(String pattern) {
        int score = 0;
        for (char c : pattern.toCharArray()) {
            if (c == 'o') {
                score += 10;
            } else if (c == 'x') {
                score += 0;
            } else {
                throw new IllegalArgumentException("Invalid shooting character: " + c);
            }
        }
        return score;
    }

}