package org.kaushik.javabrains.rest.customParamConverter;

import java.util.Calendar;

import javax.ws.rs.ext.ParamConverter;

public class MyDateParamConverter<T> implements ParamConverter<T>{

	@Override
	public T fromString(String value) {
		Calendar requestDate = Calendar.getInstance();
		
		if("tommorow".equalsIgnoreCase(value)) {
			requestDate.add(Calendar.DATE, 1);
		}
		
		else if("yesterday".equalsIgnoreCase(value)) {
			requestDate.add(Calendar.DATE, -1);
		}
		
		MyDate mydate = new MyDate();
		mydate.setDate(requestDate.get(Calendar.DATE));
		mydate.setMonth(requestDate.get(Calendar.MONTH));
		mydate.setYear(requestDate.get(Calendar.YEAR));
		
		return (T) mydate;
	}
	
	@Override
	public String toString(T myBean) {
		if(myBean == null) {
			return null;
		}
		return myBean.toString();
	}


}
