import org.junit.jupiter.api.Test;
import ro.scoala_informala.FestivalGate;
import ro.scoala_informala.TicketType;

import java.util.EnumMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StatisticsWorkTest {
    @Test
    public void statisticsWorKTest() {
        FestivalGate gate = new FestivalGate();

        gate.add(TicketType.full);
        gate.add(TicketType.full);
        gate.add(TicketType.one_day);

        Map<TicketType, Integer> stats = new EnumMap<>(TicketType.class);

        for (TicketType type : TicketType.values()) {
            stats.put(type, 0);
        }

        for (TicketType type : gate.getTickets()) {
            stats.put(type, stats.get(type) + 1);
        }

        assertEquals(2, stats.get(TicketType.full));
        assertEquals(1, stats.get(TicketType.one_day));
        assertEquals(0, stats.get(TicketType.full_vip));
        assertEquals(0, stats.get(TicketType.free_pass));
        assertEquals(0, stats.get(TicketType.one_day_vip));
    }
}

