package org.kaushik.javabrains.rest.customParamConverter;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.Calendar;

import javax.ws.rs.ext.ParamConverter;
import javax.ws.rs.ext.ParamConverterProvider;
import javax.ws.rs.ext.Provider;

@Provider
public class MyDateParamConverterProvider implements ParamConverterProvider {

	@Override
	//public <T> ParamConverter<T> getConverter(Class<T> arg0, Type arg1, Annotation[] arg2) {
	public <T> ParamConverter<T> getConverter(final Class<T> rawType, Type genericType, Annotation[] annotations) {
		if(rawType.getName().equals(MyDate.class.getName())) {
			return (ParamConverter<T>) new MyDateParamConverter<T>();
		}
		return null;
	}

}
