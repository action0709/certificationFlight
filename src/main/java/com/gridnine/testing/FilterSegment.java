package com.gridnine.testing;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;
import java.util.Set;

public interface FilterSegment {
    void printFlight(Collection<Flight> flights);

    List<Flight> getDepartureAfterCurrentTime(List<Flight> flights);

    Set<Flight> getArrivalDateEarlierDepartureDate(List<Flight> flights);

    Set<Flight> getTimeOnEarthIsMoreTwoHours(List<Flight> flights);

}