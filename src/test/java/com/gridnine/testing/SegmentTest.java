package com.gridnine.testing;

import org.junit.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.junit.Assert.*;

public class SegmentTest {
    @Test
    public void testSegmentConstructorAndGetters() {
        LocalDateTime departure = LocalDateTime.of(2022, 1, 1, 12, 0);
        LocalDateTime arrival = LocalDateTime.of(2022, 1, 1, 14, 0);
        Integer id = 1;

        Segment segment = new Segment(departure, arrival, id);

        assertEquals(id, segment.getId());
        assertEquals(departure, segment.getDepartureDate());
        assertEquals(arrival, segment.getArrivalDate());

        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
        String expectedToString = '[' + departure.format(fmt) + '|' + arrival.format(fmt) + ']';
        assertEquals(expectedToString, segment.toString());
    }
    @Test(expected = NullPointerException.class)
    public void testSegmentConstructorWithNullDeparture() {
        new Segment(null, LocalDateTime.now(), 1);
    }
    @Test(expected = NullPointerException.class)
    public void testSegmentConstructorWithNullArrival() {
        new Segment(LocalDateTime.now(), null, 1);
    }
}