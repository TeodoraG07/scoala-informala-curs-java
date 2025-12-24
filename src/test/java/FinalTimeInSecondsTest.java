import org.junit.Test;
import ro.scoala_informala.Athletes;

import static org.junit.Assert.assertEquals;

public class FinalTimeInSecondsTest {

    @Test
    public void finalTimeInSecondsTest() {
        Athletes a = new Athletes (12, "Maria", Athletes.Country.UK, 1000, 10,0,20);
        assertEquals(1030, a.finalTimeSeconds());
    }
}

