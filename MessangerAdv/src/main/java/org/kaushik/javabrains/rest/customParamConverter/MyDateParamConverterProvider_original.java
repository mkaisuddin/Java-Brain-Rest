package org.kaushik.javabrains.rest.customParamConverter;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.Calendar;

import javax.ws.rs.ext.ParamConverter;
import javax.ws.rs.ext.ParamConverterProvider;
import javax.ws.rs.ext.Provider;

//@Provider //#1 - automatically discovered by the JAX-RS runtime during a provider scanning phase.
public class MyDateParamConverterProvider_original implements ParamConverterProvider {//#2 - implement the ParamConverterProvider interface

	@Override
	//public <T> ParamConverter<T> getConverter(Class<T> arg0, Type arg1, Annotation[] arg2) {
	public <T> ParamConverter<T> getConverter(final Class<T> rawType, Type genericType, Annotation[] annotations) { //#3 -implement the ParamConverterProvider interface
		if(rawType.getName().equals(MyDate.class.getName())) {
			//return (ParamConverter<T>) new MyDateParamConverter();
			return new ParamConverter<T>() {//#4 - add the ParamConverter for MyDate class
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
						
						return rawType.cast(mydate);
					}
					
					@Override
					public String toString(T myBean) {
						if(myBean == null) {
							return null;
						}
						return myBean.toString();
					}
				};
			
		}
		return null;
	}

}
