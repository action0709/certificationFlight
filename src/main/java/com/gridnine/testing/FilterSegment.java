package com.gridnine.testing;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

public interface FilterSegment {
    void printListFlight(List<Flight> flights);

    List<Flight> getDepartureBeforeCurrentTime(List<Flight> flights);

    Set<Flight> getArrivalDateEarlierDepartureDate(List<Flight> flights);
    void printSetFlight(Set<Flight> flights);

}