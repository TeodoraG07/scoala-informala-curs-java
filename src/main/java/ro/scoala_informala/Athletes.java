package ro.scoala_informala;

public class Athletes {
    protected int id;
    private String name;
    Country country;
    protected double skiTimeInSeconds;
    protected double firstShootingRange;
    protected double secondShootingRange;
    protected double thirdShootingRange;
int finalTimeSeconds;
    public Athletes(int id, String name, Country country, double skiTimeInSeconds, double firstShootingRange, double secondShootingRange, double thirdShootingRange) {
        this.id = id;
        this.name = name;
        this.country = country;
        this.skiTimeInSeconds = skiTimeInSeconds;
        this.firstShootingRange=firstShootingRange;
        this.secondShootingRange=secondShootingRange;
        this.thirdShootingRange=thirdShootingRange;
    }


    public enum Country {
        RO, UK, SK, CZ
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
        return (int) (skiTimeInSeconds + firstShootingRange +secondShootingRange + thirdShootingRange);
    }

public String getName(){
        return name;
    }



}
