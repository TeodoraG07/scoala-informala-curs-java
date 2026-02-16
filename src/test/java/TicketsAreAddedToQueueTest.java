import org.junit.jupiter.api.Test;
import ro.scoala_informala.FestivalGate;
import ro.scoala_informala.TicketType;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TicketsAreAddedToQueueTest {
    @Test
    void ticketsAreAddedToQueue() {
        FestivalGate gate = new FestivalGate();

        gate.add(TicketType.full);
        gate.add(TicketType.one_day_vip);

        assertEquals(2, gate.getTickets().size());
        assertTrue(gate.getTickets().contains(TicketType.full));
        assertTrue(gate.getTickets().contains(TicketType.one_day_vip));
    }
}
