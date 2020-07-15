package com.higer.jdk8.Date;

import org.junit.Test;

import java.time.*;
import java.time.temporal.ChronoUnit;
import java.util.Set;
import java.util.TreeSet;

public class Java8TimeTest {

    public static void main(String[] args) {
        LocalDate localDate = LocalDate.now();
        System.out.println(localDate);
        System.out.println(localDate.getYear() + "," + localDate.getMonthValue() + "," + localDate.getDayOfMonth());

        LocalDate localDate2 = LocalDate.of(2017, 3, 3);
        System.out.println(localDate2);
        System.out.println("---------------------");
        LocalDate localDate3 = LocalDate.of(2010, 3, 25);
        MonthDay monthDay = MonthDay.of(localDate3.getMonth(), localDate3.getDayOfMonth());
        MonthDay monthDay2 = MonthDay.from(LocalDate.of(2011, 3, 25));
        System.out.println(monthDay);
        System.out.println(monthDay2);

        System.out.println("---------------");
        LocalTime time = LocalTime.now();
        System.out.println(time);
        System.out.println("-----------------");

        LocalTime time2 = time.plusHours(3).plusMinutes(20);
        System.out.println(time2);
        System.out.println("-----------------");

        LocalDate localDate1 = localDate.plus(2, ChronoUnit.WEEKS);
        System.out.println(localDate1);
        System.out.println("----------");

        LocalDate localDate4 = localDate.minus(2, ChronoUnit.MONTHS);
        System.out.println(localDate4);
        System.out.println("----------");

        Clock clock = Clock.systemDefaultZone();
        System.out.println(clock.millis());
        System.out.println("----------");

        LocalDate localDate5 = LocalDate.now();
        LocalDate localDate6 = LocalDate.of(2019, 9, 30);
        System.out.println(localDate5.isBefore(localDate6));
        System.out.println(localDate5.isAfter(localDate6));
        System.out.println(localDate5.equals(localDate6));
        System.out.println("----------");


    }

    @Test
    public void testZone() {
        //时区
        Set<String> set = ZoneId.getAvailableZoneIds();
        Set<String> treeSet = new TreeSet<String>() {
            {
                addAll(set);
            }
        };
        //treeSet.stream().forEach(System.out::println);
        System.out.println("---------");
        ZoneId zoneId = ZoneId.of("Asia/Shanghai");
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime);
        ZonedDateTime zonedDateTime = ZonedDateTime.of(localDateTime, zoneId);
        System.out.println(zonedDateTime);
        System.out.println("-----------");
    }

    @Test
    public void testYearMonth() {
        YearMonth yearMonth = YearMonth.now();
        System.out.println(yearMonth);
        System.out.println(yearMonth.lengthOfYear());
        System.out.println(yearMonth.isLeapYear());//闰年
        System.out.println("---------------");

        YearMonth yearMonth1 = YearMonth.of(2016, 2);
        System.out.println(yearMonth1);
        System.out.println(yearMonth1.lengthOfYear());
        System.out.println(yearMonth1.lengthOfMonth());
        System.out.println(yearMonth1.isLeapYear());
        System.out.println("--------------------");


    }

    @Test
    public void testPeriod() {
        LocalDate localDate = LocalDate.now();
        LocalDate localDate2 = LocalDate.of(2019, 10, 30);
        //周期性
        Period period = Period.between(localDate, localDate2);
        System.out.println(period.getYears());
        System.out.println(period.getMonths());
        System.out.println(period.getDays());
        System.out.println("-----------");
        System.out.println(Instant.now());
    }
}
