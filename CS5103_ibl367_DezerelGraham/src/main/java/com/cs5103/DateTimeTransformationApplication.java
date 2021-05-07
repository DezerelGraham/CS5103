package com.cs5103;

import java.util.Scanner;

public class DateTimeTransformationApplication {
    public static void main(String[] args){
        DateTimeConverter dateTimeConverter = new DateTimeConverter();
        Scanner myObj = new Scanner(System.in);
        System.out.println("Enter date and time(yyyy-MM-dd hh:mm:ss)");
        String time = myObj.nextLine();

        System.out.println("Enter target timezone(CST, PST, etc...)");
        String targetZone = myObj.nextLine();

        System.out.println("Enter Daylight Savings Start DateTime(yyyy-MM-dd hh:mm:ss): ");
        String dayLightStartTime = myObj.nextLine();

        System.out.println("Enter Daylight Savings End DateTime(yyyy-MM-dd hh:mm:ss): ");
        String dayLightEndTime = myObj.nextLine();

        System.out.println();
        System.out.println(dateTimeConverter.convertTime(time, targetZone, dayLightStartTime, dayLightEndTime) + " " + targetZone);
    }
}
