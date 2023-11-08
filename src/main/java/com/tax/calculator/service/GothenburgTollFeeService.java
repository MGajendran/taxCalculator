package com.tax.calculator.service;

import com.tax.calculator.freevehicles.GothenburgFreeVehicles;
import com.tax.calculator.holidays.GothenburgHolidays;
import com.tax.calculator.rates.GothenburgRates;
import com.tax.calculator.vehicle.Vehicle;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;


@Service
public class GothenburgTollFeeService implements TollSystem {
    public int calculateTollFee(Vehicle vehicle, List<LocalDateTime> times) {

        int totalCost = 0;
        int lastTollRate = 0;


        for (int i = 0; i < times.size() - 1; i++) {
            LocalDateTime start = times.get(i);
            LocalDateTime end = times.get(i + 1);

            long minutes = start.until(end, java.time.temporal.ChronoUnit.MINUTES);

            int startHour = start.getHour();
            int startMinute = start.getMinute();
            int endHour = end.getHour();
            int endMinute = end.getMinute();

            int cost = getTollRate(startHour, startMinute);
            for (int hour = startHour; hour <= endHour; hour++) {
                for (int min = (hour == startHour ? startMinute : 0); min <= (hour == endHour ? endMinute : 59); min++) {
                    cost = Math.max(cost, getTollRate(hour, min));
                }
            }

            lastTollRate = Math.max(lastTollRate, cost);

            if (i == 0 || minutes >= 60) {
                totalCost += lastTollRate;
            }
        }

        return Math.min(totalCost, 60);
    }

    @Override
    public boolean isTollFreeVehicle(Vehicle vehicle) {
        return new GothenburgFreeVehicles().isFreeVehicle(vehicle);
    }

    @Override
    public boolean isTollFreeDate(LocalDate date) {
        return new GothenburgHolidays().isTollFreeDate(date);
    }

    int getTollRate(int hour, int min) {
        return new GothenburgRates().getRates(hour, min);
    }

}