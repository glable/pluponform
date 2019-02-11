package com.mota.util;

import org.springframework.scheduling.support.CronSequenceGenerator;

import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 
 * ClassName: TmriDateUtil <br/> 
 * Function: ���ڹ����� <br/> 
 * date: 2017��3��27�� ����12:01:15 <br/> 
 * 
 * @author geliang 
 * @version  
 * @since JDK 1.7
 */
public class TmriDateUtil {
	private static SimpleDateFormat DateTimeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	/**
	 * 
	 * getNowDate:�õ���ǰʱ��  yyyy-MM-dd HH:mm:ss<br/> 
	 * 
	 * @author geliang 
	 * @return
	 */
	public static Date getNowDate() {

		Date currentTime = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateString = formatter.format(currentTime);
		ParsePosition pos = new ParsePosition(0);
		Date currentTime_2 = formatter.parse(dateString, pos);
		return currentTime_2;
	}

	
	/**
	 * 
	 * getNowDate:�õ���ǰʱ��  yyyy-MM-dd<br/> 
	 * 
	 * @author geliang 
	 * @return
	 */
	public static Date getNowDateShort() {

		Date currentTime = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		String dateString = formatter.format(currentTime);
		ParsePosition pos = new ParsePosition(0);
		Date currentTime_2 = formatter.parse(dateString, pos);
		return currentTime_2;
	}

	/**
	 * 
	 * getStringDate:��ǰʱ��ʱ����ַ��� yyyy-MM-dd HH:mm:ss <br/> 
	 * 
	 * @author geliang 
	 * @return
	 */
	public static String getStringDate() {

		Date currentTime = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateString = formatter.format(currentTime);
		return dateString;
	}

	/**
	 * 
	 * getStringDateForDigital:��ȡʱ����ַ�����ʽ.yyyyMMddHHmmss <br/> 
	 * 
	 * @author geliang 
	 * @return
	 */
	public static String getStringDateForDigital() {

		Date currentTime = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
		String dateString = formatter.format(currentTime);
		return dateString;
	}
	
	/**
	 * 
	 * getStringByFormat:�����Զ����ʽ �������ڸ�ʽ <br/> 
	 * @author geliang 
	 * @param format
	 * @param dateStr
	 * @return
	 */
	public static Date getDateByFormat(String format,String dateStr){
		SimpleDateFormat formatter = new SimpleDateFormat(format);
		Date date = null;
		try {
			date =  formatter.parse(dateStr);
		} catch (ParseException e) {
//			TmriLogUtil.infoToFile(e);
		}
		return date;
	}
	
	/**
	 * 
	 * getStrByFormat:�����Զ����ʽ ת������Ϊstring <br/> 
	 * @author geliang 
	 * @param format
	 * @param date
	 * @return
	 */
	public static String getStrByFormat(String format,Date date){
		SimpleDateFormat formatter = new SimpleDateFormat(format);
		return formatter.format(date);
	}

	/**
	 * 
	 * getStringDateForDigital:��ȡʱ����ַ�����ʽ.yyyy-MM-dd <br/> 
	 * 
	 * @author geliang 
	 * @return
	 */
	public static String getStringDateShort() {

		Date currentTime = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		String dateString = formatter.format(currentTime);
		return dateString;
	}

	/**
	 * 
	 * getStringDateShort:����ָ����ʽ��ȡ�ַ�����ʽ��ʱ�� <br/> 
	 * 
	 * @author geliang 
	 * @param format
	 * @return
	 */
	public static String getStringDateShort(String format) {

		Date currentTime = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat(format);
		String dateString = formatter.format(currentTime);
		return dateString;
	}

	/**
	 * 
	 * getTimeShort:��ȡʱ��. <br/> 
	 * 
	 * @author geliang 
	 * @return
	 */
	public static String getTimeShort() {

		SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
		Date currentTime = new Date();
		String dateString = formatter.format(currentTime);
		return dateString;
	}

	/**
	 *
	 * getPreMonth
	 *
	 * @author sunhan
	 * @param date
	 * @return
	 */
	public static String getPreMonth(String dateStr,String format,int n) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(getDateByFormat(format, dateStr));
		calendar.add(Calendar.MONTH, -n);
		return getStrByFormat(format, calendar.getTime());
	}

	/**
	 * 
	 * strToDateLong:���ַ���ת����ʱ��. <br/> 
	 * 
	 * @author geliang 
	 * @param strDate
	 * @return
	 */
	public static Date strToDateLong(String strDate) {

		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		ParsePosition pos = new ParsePosition(0);
		Date strtodate = formatter.parse(strDate, pos);
		return strtodate;
	}

	/**
	 * 
	 * dateToStrLong:������ת��Ϊ�ַ���<br/> 
	 * 
	 * @author geliang 
	 * @param dateDate
	 * @return
	 */
	public static String dateToStrLong(Date dateDate) {

		if (dateDate == null) {
			return null;
		}
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateString = formatter.format(dateDate);
		return dateString;
	}

	/**
	 * 
	 * millisToStrLong:��������תʱ�� <br/> 
	 * 
	 * @author geliang 
	 * @param millis
	 * @return
	 */
	public static String millisToStrLong(long millis) {

		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateString = formatter.format(new Date(millis));
		return dateString;
	}

	/**
	 * 
	 * dateToStr:ָ������ת�ַ���<br/> 
	 * 
	 * @author geliang 
	 * @param dateDate
	 * @return
	 */
	public static String dateToStr(Date dateDate) {

		if (dateDate == null) {
			return null;
		}
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		String dateString = formatter.format(dateDate);
		return dateString;
	}


	public static String getPrevDayStr(String date, String format)
			throws ParseException
	{
		Date d = getDateByFormat(format, date);
		Calendar cal = Calendar.getInstance();
		cal.setTime(d);
		cal.set(5, cal.get(5) - 1);
		Date nextD = cal.getTime();
		return getStrByFormat(format, nextD);
	}


}
