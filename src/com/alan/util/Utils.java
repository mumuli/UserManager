package com.alan.util;

import java.util.Calendar;
import java.util.Date;

public class Utils {
	public static int getAge(Date birthday) {
		int age = 0;
		
		Calendar c = Calendar.getInstance();
		int year = c.get(Calendar.YEAR);
		c.setTime(birthday);
		age = year - c.get(Calendar.YEAR);
		
		return age;
	}
}
