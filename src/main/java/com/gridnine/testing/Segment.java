package com.gridnine.testing;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;
/**
 * Represents a flight segment with a unique identifier, departure date, and arrival date.
 */
public class Segment {

    private final Integer id;
    private final LocalDateTime departureDate;

    private final LocalDateTime arrivalDate;
    /**
     * Constructs a Segment object with the specified departure date, arrival date, and identifier.
     *
     * @param dep Departure date of the segment.
     * @param arr Arrival date of the segment.
     * @param id  Unique identifier for the segment.
     */
    Segment(final LocalDateTime dep, final LocalDateTime arr, Integer id) {
        departureDate = Objects.requireNonNull(dep);
        arrivalDate = Objects.requireNonNull(arr);
        this.id = id;
    }
    /**
     * Retrieves the unique identifier of the segment.
     *
     * @return Integer representing the segment's identifier.
     */
    public Integer getId() {
        return id;
    }
    /**
     * Retrieves the departure date of the segment.
     *
     * @return LocalDateTime representing the departure date.
     */
    LocalDateTime getDepartureDate() {
        return departureDate;
    }
    /**
     * Retrieves the arrival date of the segment.
     *
     * @return LocalDateTime representing the arrival date.
     */
    LocalDateTime getArrivalDate() {
        return arrivalDate;
    }
    /**
     * Returns a string representation of the segment, including departure and arrival dates.
     *
     * @return String representation of the segment.
     */
    @Override
    public String toString() {
        DateTimeFormatter fmt =
                DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
        return '[' + departureDate.format(fmt) + '|' + arrivalDate.format(fmt)
                + ']';
    }
}

