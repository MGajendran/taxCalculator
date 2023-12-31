package com.tax.calculator.rates;

import java.time.LocalTime;

public class GothenburgRates implements CityRates {
    @Override
    public int[][] getRates () {

        int[][] rates = {
                {6, 0, 6, 29, 8},
                {6, 30, 6, 59, 13},
                {7, 0, 7, 59, 18},
                {8, 0, 8, 29, 13},
                {8, 30, 14, 59, 8},
                {15, 0, 15, 29, 13},
                {15, 30, 16, 59, 18},
                {17, 0, 17, 59, 13},
                {18, 0, 18, 29, 8},
                {18, 30, 5, 59, 0}
        };

        return rates;
    }
}
