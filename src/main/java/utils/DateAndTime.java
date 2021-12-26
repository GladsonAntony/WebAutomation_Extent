package utils;

import org.joda.time.DateTime;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author Gladson Antony
 * @Date 28-Jan-2017
 */


public class DateAndTime {
    /*	To get the Current Time */
    public static String getTime() throws Exception {
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("kk.mm");
        return dateFormat.format(date);
    }

    /*	To get the Current Date */
    public static String getDate() throws Exception {
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy");
        return dateFormat.format(date);
    }

    /*	To get the Current Month in Integer */
    public static int getMonth_Integer() throws Exception {
        DateTime datetime = DateTime.now();
        return datetime.getMonthOfYear();
    }

    /*	To get the Current Month Text as Full in String*/
    public static String getMonth_Full() throws Exception {
        DateTime datetime = DateTime.now();
        return datetime.monthOfYear().getAsText();
    }

    /*	To get the Current Month Text as Short in String*/
    public static String getMonth_Short() throws Exception {
        DateTime datetime = DateTime.now();
        return datetime.monthOfYear().getAsShortText();
    }

    /*	To get the Current Day of the Month */
    public static String getDayOfTheMonth() throws Exception {
        DateTime datetime = DateTime.now();
        return datetime.dayOfMonth().getAsText();
    }

    /*	To get the Current Day Count in the Year */
    public static String getDayCount() throws Exception {
        DateTime datetime = DateTime.now();
        return datetime.dayOfYear().getAsText();
    }

    /*	To get the Current Minute of the Hour in String */
    public static String getMinuteOfTheHourAsString() throws Exception {
        DateTime datetime = DateTime.now();
        return datetime.minuteOfHour().getAsText();
    }

    /*	To get the Current Year as Integer */
    public static int getYear() throws Exception {
        DateTime datetime = DateTime.now();
        return datetime.getYear();
    }

    /*	To get the Current Hour of the Day in String */
    public static String getHourOfTheDay() throws Exception {
        DateTime datetime = DateTime.now();
        return datetime.hourOfDay().getAsShortText();
    }

    /*	To get the Current Week Count */
    public static String getWeekCount() throws Exception {
        DateTime datetime = DateTime.now();
        return datetime.weekOfWeekyear().getAsText();
    }
}
