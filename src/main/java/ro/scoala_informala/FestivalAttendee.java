package ro.scoala_informala;


import java.util.Random;

public class FestivalAttendee extends Thread {
    private final TicketType ticketType;
    private final FestivalGate festivalGate;

    public FestivalAttendee(TicketType ticketType, FestivalGate festivalGate) {
        this.ticketType = ticketType;
        this.festivalGate = festivalGate;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(new Random().nextInt(2000));
            festivalGate.add(ticketType);
            System.out.println("An attendee has been added " + ticketType);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}


