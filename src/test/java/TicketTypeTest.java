import org.junit.jupiter.api.Test;
import ro.scoala_informala.TicketType;

import static org.junit.jupiter.api.Assertions.*;

public class TicketTypeTest {
    @Test
    public void enumAcceptsOnlyDefinedValues() {

        assertDoesNotThrow(() -> TicketType.valueOf("full"));
        assertDoesNotThrow(() -> TicketType.valueOf("full_vip"));
        assertDoesNotThrow(() -> TicketType.valueOf("free_pass"));
        assertDoesNotThrow(() -> TicketType.valueOf("one_day"));
        assertDoesNotThrow(() -> TicketType.valueOf("one_day_vip"));

        assertThrows(IllegalArgumentException.class,
                () -> TicketType.valueOf("invalid_ticket"));
    }
}
