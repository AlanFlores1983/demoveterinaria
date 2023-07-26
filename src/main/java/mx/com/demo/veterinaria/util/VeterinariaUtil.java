package mx.com.demo.veterinaria.util;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang3.time.DateUtils;

import java.util.ArrayList;

public class VeterinariaUtil {

	private final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");
	private final SimpleDateFormat DATE_TIME_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	ArrayList<String> formatos = new ArrayList<String>();


	public VeterinariaUtil() {
		formatos.add("EEE MMM dd HH:mm:ss.SSS yyyy");
		formatos.add("dd/MM/yyyy HH:mm:ssZ");
		formatos.add("dd/MM/yyyy");	
		formatos.add("dd.MM.yyyy");	
		formatos.add("yyyy-MM-dd HH:mm:ss");
	}

	public String convertLong2DateString(long fecha) {
		String retorno = null;
		
		try {
			Date date=new Date(fecha);
			SimpleDateFormat df2 = new SimpleDateFormat(formatos.get(0));
			retorno = df2.format(date);
		}catch(Exception e) {
			e.printStackTrace();
			retorno = "";
		}

		return retorno;
	}
	
	public String convertLong2DateStringPunto(long fecha) {
		String retorno = null;
		try {
			Date date=new Date(fecha);
			SimpleDateFormat df2 = new SimpleDateFormat(formatos.get(3));
			retorno = df2.format(date);
		}catch(Exception e) {
			e.printStackTrace();
			retorno = "";
		}

		return retorno;
	}
	

	public java.sql.Date parseDate(String date) {
	    try {
	        return new java.sql.Date(DATE_FORMAT.parse(date).getTime());
	    } catch (ParseException e) {
	        throw new IllegalArgumentException(e);
	    }
	}
	 
	public java.sql.Timestamp parseTimestamp(String timestamp) {
	    try {
	        return new Timestamp(DATE_TIME_FORMAT.parse(timestamp).getTime());
	    } catch (ParseException e) {
	        throw new IllegalArgumentException(e);
	    }
	}
	
	public String getCurrentTime(int minutes) {
	    try {
	    	String timeStamp = new SimpleDateFormat(formatos.get(4)).format( DateUtils.addMinutes(new java.util.Date(), minutes));
	    	//String timeStamp = new SimpleDateFormat(this.DATE_TIME_FORMAT).format(new java.util.Date());
	        return timeStamp;
	    } catch (Exception e) {
	        throw new IllegalArgumentException(e);
	    }
	}

}
