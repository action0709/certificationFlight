package com.gridnine.testing;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class FilterSegmentImpl implements FilterSegment {


    public void printListFlight(List<Flight> flights) {
        for (Flight flight : flights) {
            System.out.println("Рейс - " + flight.getId());
            for (int i = 0; i < flight.getSegments().size(); i++) {
                System.out.println(flight.getSegments().get(i)
                        + " Сегмент -"
                        + flight.getSegments().get(i).getId());
            }
        }
    }



    public Set<Flight> GetDepartureBeforeCurrentTime (List<Flight> flights){

    LocalDateTime timeActual = LocalDateTime.now();
    Set<Flight> resultFlight = new HashSet<>();
    List<Segment> segments = new ArrayList<>();
        for (Flight flight : flights) {
            segments.addAll(flight.getSegments());

            while (segments.size() > 0) {
                LocalDateTime departureTime = (segments.get(0).getDepartureDate());
                LocalDateTime arrivalTime = (segments.remove(0).getArrivalDate());
                if (departureTime.isAfter(timeActual)) {
                   printFlight (flight,departureTime,arrivalTime);
                    resultFlight.add(flight);
                }
            }

        }
        return resultFlight;
    }

    private void printFlight(Flight flight, LocalDateTime departureTime, LocalDateTime arrivalTime) {
        /*DateTimeFormatter dateTimeFormatter = getDateFormatter();*/
        System.out.println("Рейс - " + flight.getId() + "\n" + "Время отправления: "
                + departureTime+ "\n" + "Время прибытия: "
                + arrivalTime);
        System.out.println("___________________________________________________");

    }
}


