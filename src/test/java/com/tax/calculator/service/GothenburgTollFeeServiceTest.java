package com.tax.calculator.service;
import com.tax.calculator.vehicle.Vehicle;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class GothenburgTollFeeServiceTest {

    private GothenburgTollFeeService tollFeeService;
    private Vehicle mockVehicle;

    @BeforeEach
    public void setUp() {
        tollFeeService = new GothenburgTollFeeService();
        mockVehicle = new Vehicle("Car");
    }

    @Test
    public void testCalculateTollFee_FreeVehicleAndDate() {
        List<LocalDateTime> times = new ArrayList<>();
        times.add(LocalDateTime.of(2023, 11, 7, 8, 0));
        times.add(LocalDateTime.of(2023, 11, 7, 9, 30));

        int calculatedFee = tollFeeService.calculateTollFee(mockVehicle, times);

        int expectedFee = 13;

        assertEquals(expectedFee, calculatedFee);
    }

    @Test
    public void testCalculateTollFee_StandardRates() {
        List<LocalDateTime> times = new ArrayList<>();
        times.add(LocalDateTime.of(2023, 11, 7, 8, 0));
        times.add(LocalDateTime.of(2023, 11, 7, 15, 20));

        int calculatedFee = tollFeeService.calculateTollFee(mockVehicle, times);

        int expectedFee = 13;

        assertEquals(expectedFee, calculatedFee);
    }

    @Test
    public void testCalculateTollFee_CustomRates() {
        List<LocalDateTime> times = new ArrayList<>();
        times.add(LocalDateTime.of(2023, 11, 7, 6, 0));
        times.add(LocalDateTime.of(2023, 11, 7, 15, 00));

        int calculatedFee = tollFeeService.calculateTollFee(mockVehicle, times);

        int expectedFee = 18;

        assertEquals(expectedFee, calculatedFee);
    }
}
