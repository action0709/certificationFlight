package com.gridnine.testing;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

public interface FilterSegment {
    void printListFlight(List<Flight> flights);

    Set<Flight> GetDepartureBeforeCurrentTime(List<Flight> flights);


}