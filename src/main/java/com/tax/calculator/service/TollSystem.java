package com.tax.calculator.service;

import com.tax.calculator.vehicle.Vehicle;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

public interface TollSystem {

    int calculateTollFee(Vehicle vehicle, List<LocalDateTime> times);
    boolean isTollFreeVehicle(Vehicle vehicle);
    boolean isTollFreeDate(LocalDate date);
}
