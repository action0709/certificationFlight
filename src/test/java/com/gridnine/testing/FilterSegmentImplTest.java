package com.gridnine.testing;

import org.junit.Test;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

import static org.mockito.Mockito.*;

import static org.junit.Assert.*;

public class FilterSegmentImplTest {
    @Test
    public void testGetDepartureAfterCurrentTime() {

        FilterSegmentImpl filterSegment = new FilterSegmentImpl();
        Flight flight1 = mock(Flight.class);
        Flight flight2 = mock(Flight.class);

        Segment segment1 = new Segment(LocalDateTime.now().plusHours(1), LocalDateTime.now().plusHours(2), 1);
        Segment segment2 = new Segment(LocalDateTime.now().minusHours(3), LocalDateTime.now().plusHours(4), 2);

        when(flight1.getSegments()).thenReturn(List.of(segment1));
        when(flight2.getSegments()).thenReturn(List.of(segment2));

        List<Flight> resultFlights = filterSegment.getDepartureAfterCurrentTime(List.of(flight1, flight2));

        assertEquals(1, resultFlights.size());
        assertEquals(flight1, resultFlights.get(0));
    }

    @Test
    public void testGetArrivalDateEarlierDepartureDate() {
        Flight flight1 = mock(Flight.class);
        Segment segment1 = mock(Segment.class);
        when(segment1.getDepartureDate()).thenReturn(LocalDateTime.now().plusHours(4));
        when(segment1.getArrivalDate()).thenReturn(LocalDateTime.now().plusHours(1));
        when(flight1.getSegments()).thenReturn(Arrays.asList(segment1));

        Flight flight2 = mock(Flight.class);
        Segment segment2 = mock(Segment.class);
        when(segment2.getDepartureDate()).thenReturn(LocalDateTime.now().plusHours(1));
        when(segment2.getArrivalDate()).thenReturn(LocalDateTime.now().plusHours(3));
        when(flight2.getSegments()).thenReturn(Arrays.asList(segment2));

        Flight flight3 = mock(Flight.class);
        Segment segment3 = mock(Segment.class);
        when(segment3.getDepartureDate()).thenReturn(LocalDateTime.now().plusHours(3));
        when(segment3.getArrivalDate()).thenReturn(LocalDateTime.now().plusHours(1));
        when(flight3.getSegments()).thenReturn(Arrays.asList(segment3));

        List<Flight> flights = Arrays.asList(flight1, flight2, flight3);

        FilterSegmentImpl filterSegment = new FilterSegmentImpl();

        Set<Flight> resultFlights = filterSegment.getArrivalDateEarlierDepartureDate(flights);

        assertEquals(1, resultFlights.size());

    }

    @Test
    public void testGetTimeOnEarthIsMoreTwoHours() {

        Flight flight1 = mock(Flight.class);
        Segment segment1 = mock(Segment.class);
        when(segment1.getDepartureDate()).thenReturn(LocalDateTime.now().plusHours(3));
        when(segment1.getArrivalDate()).thenReturn(LocalDateTime.now().plusHours(8));
        Segment segment2 = mock(Segment.class);
        when(segment2.getDepartureDate()).thenReturn(LocalDateTime.now().plusHours(9));
        when(segment2.getArrivalDate()).thenReturn(LocalDateTime.now().plusHours(12));
        when(flight1.getSegments()).thenReturn(Arrays.asList(segment1,segment2));

        Flight flight2 = mock(Flight.class);
        Segment segment3 = mock(Segment.class);
        when(segment3.getDepartureDate()).thenReturn(LocalDateTime.now().plusHours(1));
        when(segment3.getArrivalDate()).thenReturn(LocalDateTime.now().plusHours(5));
        Segment segment4 = mock(Segment.class);
        when(segment4.getDepartureDate()).thenReturn(LocalDateTime.now().plusHours(9));
        when(segment4.getArrivalDate()).thenReturn(LocalDateTime.now().plusHours(12));
        when(flight2.getSegments()).thenReturn(Arrays.asList(segment3,segment4));
        FilterSegmentImpl filterSegment = new FilterSegmentImpl();

        Set<Flight> resultFlights = filterSegment.getTimeOnEarthIsMoreTwoHours(Arrays.asList(flight1, flight2));

        assertEquals(1, resultFlights.size());

         for (Flight flight : resultFlights) {
            assertEquals(flight.getSegments().size(), 2);
        }
    }
}