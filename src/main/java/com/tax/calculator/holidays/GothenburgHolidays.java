package com.tax.calculator.holidays;

import java.time.LocalDate;
import java.time.Month;

public class GothenburgHolidays implements Holidays{
    @Override
    public boolean isTollFreeDate(LocalDate date) {

         return (date.getMonth() == Month.JANUARY && date.getDayOfMonth() == 1) ||
                (date.getMonth() == Month.MARCH && (date.getDayOfMonth() == 28 || date.getDayOfMonth() == 29)) ||
                (date.getMonth() == Month.APRIL && (date.getDayOfMonth() == 1 || date.getDayOfMonth() == 30)) ||
                (date.getMonth() == Month.MAY && (date.getDayOfMonth() == 1 || date.getDayOfMonth() == 8 || date.getDayOfMonth() == 9)) ||
                (date.getMonth() == Month.JUNE && (date.getDayOfMonth() == 5 || date.getDayOfMonth() == 6 || date.getDayOfMonth() == 21)) ||
                (date.getMonth() == Month.JULY) ||
                (date.getMonth() == Month.NOVEMBER && date.getDayOfMonth() == 1) ||
                (date.getMonth() == Month.DECEMBER && (date.getDayOfMonth() == 24 || date.getDayOfMonth() == 25 || date.getDayOfMonth() == 26 || date.getDayOfMonth() == 31));
    }
    // we can simplify by extracting the common holidays across the world like new year, christmas.
    // pass the information via configuration file as well
}
