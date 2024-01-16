package com.gridnine.testing;

import java.time.LocalDateTime;
import java.util.List;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        FlightBuilder flightBuilder = new FlightBuilder();
        List<Flight> flightList=flightBuilder.createFlights();
        FilterSegment filterSegment = new FilterSegmentImpl();
        filterSegment.printListFlight(flightList);
        System.out.println("\n1. Без вылетов до текущего момента времени:");
        System.out.println("_______________________________________");
        filterSegment.getDepartureBeforeCurrentTime(flightList);
        System.out.println("\n2. Без сегментов с датой прилёта раньше даты вылета.:");
        System.out.println("_______________________________________");
        filterSegment.getArrivalDateEarlierDepartureDate(flightList);
    }
}