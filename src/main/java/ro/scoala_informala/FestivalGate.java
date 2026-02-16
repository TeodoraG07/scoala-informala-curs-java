package ro.scoala_informala;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class FestivalGate {
    private final Queue<TicketType> tickets = new ConcurrentLinkedQueue<TicketType>();

    public void add(TicketType ticketType) {
        tickets.add(ticketType);
    }

    public Queue<TicketType> getTickets() {
        return tickets;
    }
}
