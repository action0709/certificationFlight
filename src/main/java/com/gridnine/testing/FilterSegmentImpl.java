package com.gridnine.testing;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;


public class FilterSegmentImpl implements FilterSegment {


    public void printFlight(Collection<Flight> flights) {
        for (Flight flight : flights) {
            System.out.println("Рейс - " + flight.getId());
            for (int i = 0; i < flight.getSegments().size(); i++) {
                System.out.println(flight.getSegments().get(i)
                        + " Сегмент -"
                        + flight.getSegments().get(i).getId());
            }
        }
    }

    public List<Flight> getDepartureAfterCurrentTime(List<Flight> flights) {

        LocalDateTime timeActual = LocalDateTime.now();
        List<Flight> resultFlight = new ArrayList<>();
        for (Flight flight : flights) {
            Segment segment = flight.getSegments().get(0);
            LocalDateTime departureTime = (segment.getDepartureDate());
            LocalDateTime arrivalTime = (segment.getArrivalDate());
            if (departureTime.isAfter(timeActual)) {
                printFlight(flight, departureTime, arrivalTime);
                resultFlight.add(flight);
            }
        }

        return resultFlight;
    }

    public Set<Flight> getArrivalDateEarlierDepartureDate(List<Flight> flights) {
        Set<Flight> resultFlight = new HashSet<>();
        for (Flight flight : flights) {
            List<Segment> segments = flight.getSegments();
            boolean flightMatch = true;
            for (Segment segment : segments) {
                LocalDateTime departureTime = segment.getDepartureDate();
                LocalDateTime arrivalTime = segment.getArrivalDate();
                if (arrivalTime.isBefore(departureTime)) {
                    flightMatch = false;
                    break;
                }
            }
            if (flightMatch) {
                resultFlight.add(flight);
            }
        }
        printFlight(resultFlight);
        return resultFlight;
    }

    public Set<Flight> getTimeOnEarthIsMoreTwoHours(List<Flight> flights) {
        Set<Flight> resultFlight = new HashSet<>();
        for (Flight flight : flights) {
            List<Segment> segments = flight.getSegments();
            if (segments.size() > 1) {
                for (int i = 0; i < segments.size() - 1; i++) {
                    LocalDateTime arrivalTime = segments.get(i).getArrivalDate();
                    LocalDateTime departureTime = segments.get(i + 1).getDepartureDate();
                    Duration duration = Duration.between(arrivalTime, departureTime);
                    if (duration.toHours() <= 2) {
                        resultFlight.add(flight);
                        break;
                    }
                }
            } else {
                resultFlight.add(flight);
            }
        }
        printFlight(resultFlight);
        return resultFlight;
    }
    private void printFlight(Flight flight, LocalDateTime departureTime, LocalDateTime arrivalTime) {
        /*DateTimeFormatter dateTimeFormatter = getDateFormatter();*/
        System.out.println("Рейс - " + flight.getId() + "\n" + "Время отправления: "
                + departureTime + "\n" + "Время прибытия: "
                + arrivalTime);
        System.out.println("___________________________________________________");

    }
}


