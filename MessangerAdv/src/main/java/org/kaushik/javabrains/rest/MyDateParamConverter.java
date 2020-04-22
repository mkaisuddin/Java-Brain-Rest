package org.kaushik.javabrains.rest;

import java.util.Calendar;

import javax.ws.rs.ext.ParamConverter;

public class MyDateParamConverter<T> implements ParamConverter<T>{

	private Object rawType;
	
	public MyDateParamConverter(Class<T> rawType) {
		this.rawType = rawType;
	}

	//@Override // ****** check this ********
	public T fromString1(String value) {
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
		
		//return rawType.cast(mydate);
		return ((Class<T>) rawType).cast(mydate);
	}
	
	@Override
	public String toString(T myBean) {
		if(myBean == null) {
			return null;
		}
		return myBean.toString();
	}

	@Override
	public T fromString(String arg0) {
		// TODO Auto-generated method stub
		return null;
	}

}
