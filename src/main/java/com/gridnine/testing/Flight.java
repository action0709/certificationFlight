package com.gridnine.testing;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Represents a flight with a unique identifier and a list of segments.
 */
public class Flight {

    private final Integer id;
    private final List<Segment> segments;
    /**
     * Constructs a Flight object with the specified segments and identifier.
     *
     * @param segs List of segments for the flight.
     * @param id   Unique identifier for the flight.
     */
    Flight(final List<Segment> segs, Integer id) {
        this.id = id;
        segments = segs;
    }
    /**
     * Retrieves the unique identifier of the flight.
     *
     * @return Integer representing the flight's identifier.
     */
    public Integer getId() {
        return id;
    }
    /**
     * Retrieves the list of segments associated with the flight.
     *
     * @return List of Segment objects representing the flight's segments.
     */
    List<Segment> getSegments() {
        return segments;
    }
    /**
     * Returns a string representation of the flight, concatenating segment information.
     *
     * @return String representation of the flight.
     */
    @Override
    public String toString() {
        return segments.stream().map(Object::toString)
                .collect(Collectors.joining(" "));
    }
}
