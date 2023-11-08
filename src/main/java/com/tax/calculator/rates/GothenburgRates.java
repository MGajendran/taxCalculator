package com.tax.calculator.rates;

import java.time.LocalDateTime;
import java.util.List;

public class GothenburgRates implements CityRates {
    @Override
    public int getRates (int hour, int min) {

        record HourRange(int startHour, int startMinute, int endHour, int endMinute, int value) {}

        var hourRanges = List.of(
                new HourRange(6, 0, 6, 29, 8),
                new HourRange(6, 30, 6, 59, 13),
                new HourRange(7, 0, 7, 59, 18),
                new HourRange(8, 0, 8, 29, 13),
                new HourRange(8, 30, 14, 59, 8),
                new HourRange(15, 0, 15, 29, 13),
                new HourRange(15, 30, 16, 59, 18),
                new HourRange(17, 0, 17, 59, 13),
                new HourRange(18, 0, 18, 29, 8),
                new HourRange(18, 30, 23, 59, 0),
                new HourRange(0, 0, 5, 59, 0)
        );

        return  hourRanges.stream()
                .filter(range ->
                        (hour > range.startHour() || (hour == range.startHour() && min >= range.startMinute())) &&
                                (hour < range.endHour() || (hour == range.endHour() && min <= range.endMinute()))
                )
                .map(HourRange::value)
                .findFirst()
                .orElse(0);

    }
}
