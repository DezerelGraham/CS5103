package com.cs5103;

import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.TimeZone;

public class DateTimeConverter {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    LocalDateTime newDateTime;

    public String convertTime(String time, String targetZone, String dayLightStartTime, String dayLightEndTime){
        LocalDateTime dateTime = convertToLocalDateTime(time, formatter);
        StringBuilder convertedDateTime = new StringBuilder();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        sdf.setTimeZone(TimeZone.getTimeZone(targetZone.trim()));
        Date date = Date.from(dateTime.atZone(ZoneId.systemDefault()).toInstant());

        newDateTime = convertToLocalDateTime(sdf.format(date), formatter);
        newDateTime = covertToDayLightSavingTime(newDateTime, dayLightStartTime, dayLightEndTime);

        convertedDateTime.append(newDateTime.toLocalDate().toString());
        convertedDateTime.append(" ");
        convertedDateTime.append(newDateTime.getDayOfWeek().toString());
        convertedDateTime.append(" ");
        convertedDateTime.append(newDateTime.toLocalTime().toString());

        return convertedDateTime.toString();
    }

    private LocalDateTime convertToLocalDateTime(String time, DateTimeFormatter formatter) {
        return LocalDateTime.parse(time, formatter);
    }

    private LocalDateTime covertToDayLightSavingTime(LocalDateTime newDateTime, String dayLightStartTime, String dayLightEndTime) {
        return newDateTime.isAfter(convertToLocalDateTime(dayLightStartTime, formatter))
                && newDateTime.isBefore(convertToLocalDateTime(dayLightEndTime, formatter)) ? newDateTime.plusMinutes(Long.parseLong("60")) : newDateTime;
    }
}
