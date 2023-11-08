package com.tax.calculator.service;

import com.tax.calculator.freevehicles.GothenburgFreeVehicles;
import com.tax.calculator.holidays.GothenburgHolidays;
import com.tax.calculator.rates.GothenburgRates;
import com.tax.calculator.vehicle.Vehicle;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;


@Service
public class GothenburgTollFeeService implements TollSystem {
    public int calculateTollFee(Vehicle vehicle, List<LocalDateTime> times) {

        int total = 0;
        System.out.println(vehicle.getVehicleType() + " " + isTollFreeVehicle(vehicle));
        if(isTollFreeDate(times.get(0).toLocalDate()) || isTollFreeVehicle(vehicle)) {
            System.out.println("This is inside");
            return 0;
        }

        int[][] rateRanges = getTollRate();

        for (int i = 0; i < times.size() - 1; i += 2) {
            LocalDateTime entryTime = times.get(i);
            LocalDateTime exitTime = times.get(i + 1);

            while (entryTime.isBefore(exitTime)) {
                LocalTime currentTime = entryTime.toLocalTime();

                for (int[] range : rateRanges) {
                    LocalTime rangeStartTime = LocalTime.of(range[0], range[1]);
                    LocalTime rangeEndTime = LocalTime.of(range[2], range[3]);
                    double rangeRate = range[4];

                    if (!currentTime.isBefore(rangeStartTime) && !currentTime.isAfter(rangeEndTime)) {
                        total += rangeRate;
                        entryTime = entryTime.withHour(rangeEndTime.getHour()).withMinute(rangeEndTime.getMinute());
                    }
                }

                entryTime = entryTime.plusMinutes(1);
            }
        }

        return Math.min(total, 60);
    }

    @Override
    public boolean isTollFreeVehicle(Vehicle vehicle) {
        return new GothenburgFreeVehicles().isFreeVehicle(vehicle);
    }

    @Override
    public boolean isTollFreeDate(LocalDate date) {return new GothenburgHolidays().isTollFreeDate(date);}

    public int[][] getTollRate(){ return new GothenburgRates().getRates();}

}