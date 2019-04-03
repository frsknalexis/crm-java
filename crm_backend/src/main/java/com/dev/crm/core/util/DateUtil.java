package com.dev.crm.core.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class DateUtil {

	private DateUtil() {
		
	}
	
	/**
	 * 
	 *@param date 
	 * 
	 * @return
	 * 
	 */
	public static java.sql.Date convertSQLDate(Date date) {
		
		if(GenericUtil.isNotNull(date)) {
			return new java.sql.Date(date.getTime());
		}
		return null;
	}
	
	/**
	 * 
	 * get current Date
	 * 
	 * @return Date
	 * 
	 */
	public static Date getCurrentDate() {
		
		Calendar calendar = Calendar.getInstance();
		return calendar.getTime();
	}
	
	/**
	 * 
	 *@return
	 * 
	 */
	public static Integer getCurrentYear() {
		
		Calendar calendar = Calendar.getInstance();
		return calendar.get(Calendar.YEAR);
	}
	
	/**
	 * 
	 *@return 
	 * 
	 */
	public static Integer getCurrentMonth() {
		
		Calendar calendar = Calendar.getInstance();
		return calendar.get(Calendar.MONTH);
	}
	
	/**
	 * 
	 *@return 
	 * 
	 */
	public static String getCurrentMonthDesc() {
		
		Calendar calendar = Calendar.getInstance();
		return calendar.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.getDefault());
	}
	
	/**
	 * 
	 *@return
	 * 
	 */
	public static Integer getCurrentDay() {
		
		Calendar calendar = Calendar.getInstance();
		return calendar.get(Calendar.DAY_OF_MONTH);
	}
	
	/**
	 * 
	 *@return
	 * 
	 */
	public static Integer getCurrentHour() {
		
		Calendar calendar = Calendar.getInstance();
		return calendar.get(Calendar.HOUR);
	}
	
	/**
	 * 
	 *@return 
	 * 
	 */
	public static Integer getCurrentMinute() {
		
		Calendar calendar = Calendar.getInstance();
		return calendar.get(Calendar.MINUTE);
	}
	
	/**
	 * 
	 *@return
	 * 
	 */
	public static Integer getCurrentSecond() {
		
		Calendar calendar = Calendar.getInstance();
		return calendar.get(Calendar.SECOND);
	}
	
	/**
	 * 
	 *@return
	 * 
	 */
	public static Integer getCurrentMilliSecond() {
		
		Calendar calendar = Calendar.getInstance();
		return calendar.get(Calendar.MILLISECOND);
	}
	
	/**
	 *
	 * get the name of month
	 * 
	 * @param mesId;
	 * 
	 * @return name of month
	 * 
	 */
	
	public static String getMonth(Integer mesId) {
		
		String mes = Constantes.EMPTY;
		switch(mesId) {
			case 1:mes = "Enero"; break;
			case 2:mes = "Febrero"; break;
			case 3:mes = "Marzo"; break;
			case 4:mes = "Abril"; break;
			case 5:mes = "Mayo"; break;
			case 6:mes = "Junio"; break;
			case 7:mes = "Julio"; break;
			case 8:mes = "Agosto"; break;
			case 9:mes = "Setiembre"; break;
			case 10:mes = "Octubre"; break;
			case 11:mes = "Noviembre"; break;
			case 12:mes = "Diciembre"; break;
			default:
				break;
		}
		return mes;
	}
	
	public static String getDateToText(Date date) {
		
		if(GenericUtil.isNotNull(date)) {
			
			TimeZone timeZone = TimeZone.getTimeZone("America/Lima");
			Locale locale = new Locale("es", "PE");
			Calendar calendar = Calendar.getInstance(timeZone, locale);
			calendar.setTime(date);
			DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.LONG, locale);
			return dateFormat.format(Calendar.getInstance());
		}
		return Constantes.EMPTY;
	}
	
	public static String getDateFromStringReport(Date fecha, String format) {
		
		if(GenericUtil.isNull(fecha)) {
			return Constantes.EMPTY;
		}
		SimpleDateFormat dateFormat = new SimpleDateFormat(format);
		return dateFormat.format(fecha);
	}
	
	public static Date getDateFromString(String fecha, String format) {
		
		if(GenericUtil.isNull(fecha)) {
			return getCurrentDate();
		}
		SimpleDateFormat dateFormat = new SimpleDateFormat(format);
		try {
			return dateFormat.parse(fecha);
		}
		catch(ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static String getMonthName(Date date) {
		
		if(GenericUtil.isNotNull(date)) {
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(date);
			int mesId = calendar.get(Calendar.MONTH) + 1;
			return getMonth(mesId);
		}
		return Constantes.EMPTY;
	}
}
