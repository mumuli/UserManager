package com.alan.type.converter;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import org.apache.struts2.util.StrutsTypeConverter;

public class UserDateTypeConverter extends StrutsTypeConverter {
	
	private DateFormat format;
	
	public UserDateTypeConverter() {
		format = new SimpleDateFormat("YYYY-DD-MM");
	}
	
	@Override
	public Object convertFromString(Map context, String[] values, Class toClass) {
		Date date = null;
		try {
			date = format.parse(values[0]);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return date;
	}
	
	@Override
	public String convertToString(Map context, Object o) {
		String str = null;
		if(o instanceof Date) {
			Date date = (Date)o;
			str = format.format(date);
		}
		return str;
	}
}
