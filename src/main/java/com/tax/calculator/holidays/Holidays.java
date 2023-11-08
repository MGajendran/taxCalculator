package com.tax.calculator.holidays;

import java.time.LocalDate;

public interface Holidays {

    boolean isTollFreeDate(LocalDate date);
}
