package com.aic.loveaichuang.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import android.annotation.SuppressLint;

public class TimeUtils {
	public static final String DATE_TIME_FMT3 = "yyyy-MM-dd HH:mm";
	
	/**
	 * 格式化日期
	 * 
	 * @return yyyy-MM-dd HH:mm
	 */
	public static String longDate2String3(long lngDate) {
		return getDateTime(lngDate, DATE_TIME_FMT3);
	}
	
	
	@SuppressLint("SimpleDateFormat")
	public static String getDateTime(long lngDateTime, String strFormat) {
		try {
			Date date = new Date(lngDateTime);
			DateFormat sFormatter = new SimpleDateFormat(strFormat);
			return sFormatter.format(date);
		} catch (Exception e) {
			return "";
		}
	}
	
}
