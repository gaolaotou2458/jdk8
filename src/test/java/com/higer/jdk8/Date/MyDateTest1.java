package com.higer.jdk8.Date;

import org.joda.primitives.list.IntList;
import org.joda.primitives.list.impl.ArrayIntList;
import org.joda.time.*;

import java.util.Locale;

public class MyDateTest1 {

    public boolean isAfterPayDay(DateTime datetime) {
        if (datetime.getMonthOfYear() == 2) {   // February is month 2!!
            return datetime.getDayOfMonth() > 26;
        }
        return datetime.getDayOfMonth() > 28;
    }

    public Days daysToNewYear(LocalDate fromDate) {
        LocalDate newYear = fromDate.plusYears(1).withDayOfYear(1);
        return Days.daysBetween(fromDate, newYear);
    }

    public boolean isRentalOverdue(DateTime datetimeRented) {
        Period rentalPeriod = new Period().withDays(2).withHours(12);
        return datetimeRented.plus(rentalPeriod).isBeforeNow();
    }

    public String getBirthMonthText(LocalDate dateOfBirth) {
        return dateOfBirth.monthOfYear().getAsText(Locale.ENGLISH);
    }

    public static void main(String[] args) {
        IntList intList = new ArrayIntList();
        intList.add(1);
        intList.add(2);
        intList.add(3);
        intList.forEach(System.out::println);
    }
}
