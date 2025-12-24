import org.junit.Test;
import ro.scoala_informala.Athletes;
import ro.scoala_informala.AthletesCsvReader;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class ParseCsvTest {
    @Test

    public void parseCsvTest() {
        String csvInput = "\"AthleteNumber,AthleteName,CountryCode,SkiTimeResult(Minutes:Seconds),FirstShootingRange,SecondShooting,ThirdShooting\"\n" +
                "\"11,Umar Jorgson,SK,30:27:00,xxxox,xxxxx,xxoxo\"";
        AthletesCsvReader athletesreader = new AthletesCsvReader();
        List<Athletes> actulaResults= athletesreader.parse(csvInput);
        assertEquals(1,actulaResults.stream().count());
        assertEquals(11, actulaResults.get(0).getId());

    }

}
