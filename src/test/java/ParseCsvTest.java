import org.junit.Test;
import ro.scoala_informala.Athletes;
import ro.scoala_informala.AthletesCsvReader;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static ro.scoala_informala.Athletes.Country.TR;

public class ParseCsvTest {
    @Test

    public void parseCsvTest() {
        String csvInput = "\"AthleteNumber,AthleteName,CountryCode,SkiTimeResult(Minutes:Seconds),FirstShootingRange,SecondShooting,ThirdShooting\"\n" +
                "\"11,Umar Jorgson,TR,30:27:00,xxxox,xxxxx,xxoxo\"";
        AthletesCsvReader athletesreader = new AthletesCsvReader();
        List<Athletes> actulaResults = athletesreader.parse(csvInput);
        assertEquals(1, actulaResults.stream().count());
        assertEquals(11, actulaResults.get(0).getId());
        assertEquals("Umar Jorgson", actulaResults.get(0).getName());
        assertEquals(TR, actulaResults.get(0).getCountry());
        assertEquals(1827, actulaResults.get(0).getSkiTimeInSeconds());
        assertEquals(10, actulaResults.get(0).getFirstShootingRange());
        assertEquals(0, actulaResults.get(0).getSecondShootingRange());
        assertEquals(20, actulaResults.get(0).getThirdShootingRange());

    }

}
