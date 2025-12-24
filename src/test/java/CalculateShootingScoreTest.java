import org.junit.Test;
import ro.scoala_informala.Athletes;
import static org.junit.Assert.assertEquals;

public class CalculateShootingScoreTest {
    @Test
   public  void calculateShootingScore_returnsCorrectScore() {
        Athletes athlete = new Athletes(
                1,
                "Test",
                Athletes.Country.RO,
                1000,
                0, 0, 0
        );
        int score = athlete.calculateShootingScore("oooox");
        assertEquals(40, score);
    }
}

