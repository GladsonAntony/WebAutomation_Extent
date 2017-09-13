/**
 * 
 */
package utils;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.joda.time.DateTime;

/**
 * @Author Gladson Antony
 * @Date 28-Jan-2017
 */
public class DateAndTime 
{
	/*	To get the Current Time */
	public static String getTime() throws Exception 
	{
		Date date = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("kk.mm");
		String TimeNow = dateFormat.format(date);
		return TimeNow;
	}

	/*	To get the Current Date */
	public static String getDate() throws Exception 
	{
		Date date = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy");
		String DateNow = dateFormat.format(date);
		return DateNow;
	}

	/*	To get the Current Month in Integer */
	public static int getMonth_Integer() throws Exception 
	{
		DateTime datetime = DateTime.now();
		int month = datetime.getMonthOfYear();
		return month;
	}
	
	/*	To get the Current Month Text as Full in String*/
	public static String getMonth_Full() throws Exception 
	{
		DateTime datetime = DateTime.now();
		String month_Full = datetime.monthOfYear().getAsText();
		return month_Full;
	}
	
	/*	To get the Current Month Text as Short in String*/
	public static String getMonth_Short() throws Exception 
	{
		DateTime datetime = DateTime.now();
		String month_Short = datetime.monthOfYear().getAsShortText();
		return month_Short;
	}
	
	/*	To get the Current Day of the Month */
	public static String getDayOfTheMonth() throws Exception 
	{
		DateTime datetime = DateTime.now();
		String dayOfTheMonth = datetime.dayOfMonth().getAsText();
		return dayOfTheMonth;
	}
	
	/*	To get the Current Day Count in the Year */
	public static String getDayCount() throws Exception 
	{
		DateTime datetime = DateTime.now();
		String dayCountYear = datetime.dayOfYear().getAsText();
		return dayCountYear;
	}
	
	/*	To get the Current Minute of the Hour in String */
	public static String getMinuteOfTheHourAsString() throws Exception 
	{
		DateTime datetime = DateTime.now();
		String minuteOfTheHour = datetime.minuteOfHour().getAsText();
		return minuteOfTheHour;
	}
	
	/*	To get the Current Year as Integer */
	public static int getYear() throws Exception 
	{
		DateTime datetime = DateTime.now();
		int year = datetime.getYear();
		return year;
	}
	
	/*	To get the Current Hour of the Day in String */
	public static String getHourOfTheDay() throws Exception 
	{
		DateTime datetime = DateTime.now();
		String hour = datetime.hourOfDay().getAsShortText();
		return hour;
	}
	
	/*	To get the Current Week Count */
	public static String getWeekCount() throws Exception 
	{
		DateTime datetime = DateTime.now();
		String hour = datetime.weekOfWeekyear().getAsText();
		return hour;
	}
	
	
}
