package com.meetup.contactmanager.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
    /**
     * Method used to format date string
     * @param date
     * @param format
     * @return Date value is returned
     * @throws ParseException 
     */
    public static Date formatDate(String date, String format) throws ParseException {
        DateFormat formatter = new SimpleDateFormat(format);
        Date parsedDate = null;
        
        try {
            parsedDate = (date == null ? null : formatter.parse(date));
        } catch (ParseException pe) {
            //TODO: handle exception
        }
        return parsedDate;
    }
}