package com.cs5103;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.TimeZone;

public class DateTimeConverter {
    public String convertTime(String time) throws ParseException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime dateTime = LocalDateTime.parse(time, formatter);
        StringBuilder convertedDateTime = new StringBuilder();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        sdf.setTimeZone(TimeZone.getTimeZone("America/Los_Angeles"));

        Date date = Date.from(dateTime.atZone(ZoneId.systemDefault()).toInstant());

        LocalDateTime newDateTime = LocalDateTime.parse(sdf.format(date), formatter);

        convertedDateTime.append(newDateTime.toLocalDate().toString());
        convertedDateTime.append(" ");
        convertedDateTime.append(newDateTime.getDayOfWeek().toString());
        convertedDateTime.append(" ");
        convertedDateTime.append(newDateTime.toLocalTime().toString());

        return convertedDateTime.toString();
    }
}
