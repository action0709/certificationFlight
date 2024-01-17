package com.gridnine.testing;

import java.time.LocalDateTime;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        FlightBuilder flightBuilder = new FlightBuilder();
        List<Flight> flightList = flightBuilder.createFlights();
        FilterSegment filterSegment = new FilterSegmentImpl();
        filterSegment.printFlight(flightList);
        System.out.println("\n1. Без вылетов до текущего момента времени:");
        System.out.println("_______________________________________");
        filterSegment.getDepartureAfterCurrentTime(flightList);
        System.out.println("\n2. Без сегментов с датой прилёта раньше даты вылета:");
        System.out.println("_______________________________________");
        filterSegment.getArrivalDateEarlierDepartureDate(flightList);
        System.out.println("\n3. Без перелетов, где общее время, проведённое на земле, превышает два часа:");
        System.out.println("_______________________________________");
        filterSegment.getTimeOnEarthIsMoreTwoHours(flightList);
    }
}