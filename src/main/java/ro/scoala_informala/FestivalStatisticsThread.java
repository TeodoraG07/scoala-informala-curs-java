package ro.scoala_informala;


import java.util.EnumMap;
import java.util.Map;

public class FestivalStatisticsThread extends Thread {
    private final FestivalGate festivalGate;

    public FestivalStatisticsThread(FestivalGate festivalGate) {
        this.festivalGate = festivalGate;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(5000);
                if (!festivalGate.getTickets().isEmpty()) {
                    Map<TicketType, Integer> stats = new EnumMap<TicketType, Integer>(TicketType.class);
                    for (TicketType ticketType : TicketType.values()) {
                        stats.put(ticketType, 0);
                    }

                    for (TicketType ticketType : festivalGate.getTickets()) {
                        stats.put(ticketType, stats.get(ticketType) + 1);
                    }
                    int totalTickets = festivalGate.getTickets().size();
                    System.out.println("Total tickets: " + totalTickets);
                    for (Map.Entry<TicketType, Integer> entry : stats.entrySet()) {
                        System.out.println(entry.getKey() + ": " + entry.getValue());

                    }
                    System.out.println("-----");


                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
