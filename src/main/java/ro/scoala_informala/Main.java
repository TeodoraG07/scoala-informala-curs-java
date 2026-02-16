package ro.scoala_informala;

import ro.scoala_informala.FestivalAttendee;
import ro.scoala_informala.FestivalGate;
import ro.scoala_informala.FestivalStatisticsThread;
import ro.scoala_informala.TicketType;

import java.util.Random;
public class Main {
    public static void main(String[] args) {
        System.out.println("Festival stats started");
        FestivalGate festivalGate = new FestivalGate();
        FestivalStatisticsThread festivalStatisticsThread = new FestivalStatisticsThread(festivalGate);
        festivalStatisticsThread.start();
        Random random = new Random();
        for (int i=0; i<100; i++){
            TicketType randomTicketType = TicketType.values()[random.nextInt(TicketType.values().length)];
            FestivalAttendee attendee= new FestivalAttendee(randomTicketType, festivalGate);
            attendee.start();
        }
    }

}