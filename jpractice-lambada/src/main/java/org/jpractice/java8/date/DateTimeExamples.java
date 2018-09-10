/**
 * 
 */
package org.jpractice.java8.date;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.Period;
import java.time.temporal.ChronoField;

/**
 * @author: 作者： xuefei
 * @date: 创建时间：2018-07-28 07:54:55
 * @Description: TODO
 * @version V1.0
 */
public class DateTimeExamples {

    public static void main(String[] args) {

        DateTimeExamples dateTimeExamples = new DateTimeExamples();
        dateTimeExamples.useLocalDate();

    }

    private void useLocalDate() {
        LocalDate localDate = LocalDate.of(2018, 07, 28);
        int year = localDate.getYear(); // 2018
        Month month = localDate.getMonth(); // AUGUST
        int day = localDate.getDayOfMonth(); // 28
        DayOfWeek dayOfWeek = localDate.getDayOfWeek(); // SATURDAY
        int len = localDate.lengthOfMonth();
        boolean leap = localDate.isLeapYear();

        System.out.println(localDate);
        
        LocalDate today = LocalDate.now();
        int y = today.get(ChronoField.YEAR);
        int m = today.get(ChronoField.MONTH_OF_YEAR);
        int d = today.get(ChronoField.DAY_OF_MONTH);

        LocalTime localTime = LocalTime.of(8, 23, 22);
        int hour = localTime.getHour();
        int minute = localTime.getMinute();
        int second = localTime.getSecond();

        // parse方法
        LocalDate date = LocalDate.parse("2018-08-01");
        LocalTime time = LocalTime.parse("12:44:44");

        // 合并日期和时间 LocalDateTime
        LocalDateTime dt1 = LocalDateTime.of(2018, Month.MAY, 1, 12, 44, 44);
        LocalDateTime dt2 = LocalDateTime.of(date, time);
        LocalDateTime dt3 = date.atTime(12, 44, 44);
        LocalDateTime dt4 = date.atTime(time);
        LocalDateTime dt5 = time.atDate(date);

        // 从LocalDateTime中提取LocalDate、LocalTime
        LocalDate date2 = dt1.toLocalDate();
        LocalTime time2 = dt1.toLocalTime();

        Duration duration = Duration.ofMinutes(3);

        Period tenDays = Period.ofDays(10);
        Period twoYearsSixMonthsOneDay = Period.of(2, 6, 1);

    }
}
