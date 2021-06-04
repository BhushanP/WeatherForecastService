package com.bhushan.project.weatherforecast.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DateFormatterUtil {

	public static String formatDate(Date date,String pattern) {
		DateFormat formatter = new SimpleDateFormat(pattern, Locale.ENGLISH);
		return formatter.format(date);
	}

}
