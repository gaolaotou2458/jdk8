package com.higer.jdk8.Date;

import org.joda.time.DateTime;
import org.joda.time.LocalDate;

public class JodaTest2 {

    public static void main(String[] args) {
        DateTime today = new DateTime();
        DateTime tomorrow = today.plusDays(1);

        System.out.println(today.toString("yyyy-MM-dd"));
        System.out.println(tomorrow.toString("yyyy-MM-dd"));

        DateTime d1 = today.withDayOfMonth(1);
        //日期变成1号
        System.out.println(d1.toString("yyyy-MM-dd"));
        System.out.println("--------------");

        LocalDate localDate = new LocalDate();
        System.out.println(localDate);

        LocalDate localDate1 = localDate.plusMonths(3).dayOfMonth().withMaximumValue();
        System.out.println(localDate1);

        //计算2年前，第三个月，最后一天的日期
        LocalDate localDate2 = localDate.minusYears(2).monthOfYear().setCopy(3)
                .dayOfMonth().withMaximumValue();
        System.out.println(localDate2);
    }
}
