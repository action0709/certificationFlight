package com.gridnine.testing;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

/**
 * Implementation of the FilterSegment interface providing methods to filter flights based on various criteria.
 */
public class FilterSegmentImpl implements FilterSegment {

    /**
     * Prints information about the flights and their segments.
     *
     * @param flights Collection of Flight objects to be printed.
     */
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
    /**
     * Filters flights with departure times after the current time.
     *
     * @param flights List of Flight objects to be filtered.
     * @return List of flights with departure times after the current time.
     */
    public List<Flight> getDepartureAfterCurrentTime(List<Flight> flights) {
        LocalDateTime timeActual = LocalDateTime.now();
        List<Flight> resultFlight = new ArrayList<>();
        for (Flight flight : flights) {
            Segment segment = flight.getSegments().get(0);
            LocalDateTime departureTime = (segment.getDepartureDate());
            LocalDateTime arrivalTime = (segment.getArrivalDate());
            if (departureTime.isAfter(timeActual)) {

                resultFlight.add(flight);
            }
        }
        printFlight(resultFlight);
        return resultFlight;
    }
    /**
     * Filters flights with arrival times earlier than departure times for any segment.
     *
     * @param flights List of Flight objects to be filtered.
     * @return Set of flights with arrival times earlier than departure times.
     */
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
    /**
     * Filters flights with a total time on Earth for all segments exceeding two hours.
     *
     * @param flights List of Flight objects to be filtered.
     * @return Set of flights with a total time on Earth for all segments exceeding two hours.
     */
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
}


