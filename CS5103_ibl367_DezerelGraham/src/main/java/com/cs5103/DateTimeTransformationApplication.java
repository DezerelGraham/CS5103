package com.cs5103;

import java.text.ParseException;
import java.util.Scanner;

public class DateTimeTransformationApplication {
    public static void main(String[] args) throws ParseException {
        DateTimeConverter dateTimeConverter = new DateTimeConverter();
        Scanner myObj = new Scanner(System.in);
        System.out.println("Enter date and time(yyyy-MM-dd hh:mm:ss)");

        String time = myObj.nextLine();
        System.out.println("Time in Los_Angeles:  " + dateTimeConverter.convertTime(time));
    }
}
