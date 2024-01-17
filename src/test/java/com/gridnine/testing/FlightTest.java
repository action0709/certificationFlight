package com.gridnine.testing;


import org.junit.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

 public class FlightTest {
    @Test
    public void testFlightConstructorAndGetters() {
                List<Segment> segments = Arrays.asList(
                new Segment(LocalDateTime.now(), LocalDateTime.now().plusHours(2), 1),
                new Segment(LocalDateTime.now().plusHours(3), LocalDateTime.now().plusHours(5), 2)
        );

        // Act
        Flight flight = new Flight(segments, 1);

        // Assert
        assertEquals(1, flight.getId());
        }
}
