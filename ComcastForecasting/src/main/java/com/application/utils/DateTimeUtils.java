package com.application.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateTimeUtils {
	public static Date convertStringtoDate(String date, String sourceDateFormat) throws ParseException {
		return new SimpleDateFormat(sourceDateFormat).parse(date);
	}
	
	public static Date convertStringtoDate(String date) throws ParseException {
		return new SimpleDateFormat().parse(date);
	}
	
	public static String convertDatetoString(Date date) {
		return date.toString();
	}
	
	public static String returnDateInRequestedFormat(Date date, String format) {
		return new SimpleDateFormat(format).format(date);
	}
	
	public static String returnDateInRequestedFormat(String date, String sourceFormat, String destFormat) throws ParseException {
		return new SimpleDateFormat(destFormat).format(convertStringtoDate(date,sourceFormat));
	}
	
	public static String getTime() {
		Calendar cal = new GregorianCalendar();
		return Integer.toString(cal.get(Calendar.HOUR_OF_DAY)) + ":" + Integer.toString(cal.get(Calendar.MINUTE)) + ":"
		        + Integer.toString(cal.get(Calendar.SECOND));
	}
	
	public static String getDateInTextFormat(String data, String... dateFormat) {
		Calendar cal = Calendar.getInstance();
		String format;
		
		if(dateFormat == null) {
			format = "dd/MM/yyyy";
		} else {
			format = dateFormat[0];
		}
		
		DateFormat dtFormat = new SimpleDateFormat(format);
				
		if("Tomorrow".equalsIgnoreCase(data)) {
			cal.add(Calendar.DATE, 1);
		} else if("Yesterday".equalsIgnoreCase(data)) {
			cal.add(Calendar.DATE, -1);
		} else if("Today".equalsIgnoreCase(data)) {
		} else if("DateAfterMonth".equalsIgnoreCase(data)) {
			cal.add(Calendar.DATE, +31);
		} else if(data.toLowerCase().startsWith("today+")) {
			cal.add(Calendar.DATE, Integer.valueOf(data.toLowerCase().replaceAll("today+", "")));
		} else if(data.toLowerCase().startsWith("today-")) {
			cal.add(Calendar.DATE, -Integer.valueOf(data.toLowerCase().replaceAll("today-", "")));
		}
		return dtFormat.format(cal.getTime());
	}
	public static String intToMonth(int month) {
		String monthString;
        switch (month) {
            case 1:  monthString = "January";       break;
            case 2:  monthString = "February";      break;
            case 3:  monthString = "March";         break;
            case 4:  monthString = "April";         break;
            case 5:  monthString = "May";           break;
            case 6:  monthString = "June";          break;
            case 7:  monthString = "July";          break;
            case 8:  monthString = "August";        break;
            case 9:  monthString = "September";     break;
            case 10: monthString = "October";       break;
            case 11: monthString = "November";      break;
            case 12: monthString = "December";      break;
            default: monthString = "Invalid month"; break;
        }
        return monthString;
	}
	
	public static int monthToInteger(String monthString) {
		int monthInt;
        switch (monthString) {
        case "January" : monthInt = 1; break;
        case "February" : monthInt = 2; break;
        case "March" : monthInt = 3; break;
        case "April" : monthInt = 4; break;
        case "May" : monthInt = 5; break;
        case "June" : monthInt = 6; break;
        case "July" : monthInt = 7; break;
        case "August" : monthInt = 8; break;
        case "September" : monthInt = 9; break;
        case "October" : monthInt = 10; break;
        case "November" : monthInt = 11; break;
        case "December" : monthInt = 12; break;
        default  : monthInt = 0; break;
        }
        return monthInt;
	}
	
	public static int monToInteger(String monthString) {
		int monthInt;
        switch (monthString.toUpperCase()) {
        case "JAN" : monthInt = 1; break;
        case "FEB" : monthInt = 2; break;
        case "MAR" : monthInt = 3; break;
        case "APR" : monthInt = 4; break;
        case "MAY" : monthInt = 5; break;
        case "JUN" : monthInt = 6; break;
        case "JUL" : monthInt = 7; break;
        case "AUG" : monthInt = 8; break;
        case "SEP" : monthInt = 9; break;
        case "OCT" : monthInt = 10; break;
        case "NOV" : monthInt = 11; break;
        case "DEC" : monthInt = 12; break;
        default  : monthInt = 0; break;
        }
        return monthInt;
	}
}