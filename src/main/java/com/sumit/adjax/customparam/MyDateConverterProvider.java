package com.sumit.adjax.customparam;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.Calendar;

import javax.ws.rs.ext.ParamConverter;
import javax.ws.rs.ext.ParamConverterProvider;
import javax.ws.rs.ext.Provider;

/*
 * Jersey looks up to all the converter for that certain type that can be converted.
 * i.e if I have a URI as //http://localhost:8080/advanced-jaxrs/webapi/value/hello1?query=queryValue
 * instead of String I want to have a class object of my own type say Car car.
 * So jersey provider has a method getConverter(Class<t> rawType, Type generic, Annotation annotation)
 * which takes care of the conversion.
 * for this we have to implement ParamConverterProvider interface.
 */

//in order to register this class  as a provider give the class a @provider annotation
@Provider
public class MyDateConverterProvider implements ParamConverterProvider {

	@Override
	public <T> ParamConverter<T> getConverter(Class<T> rawType, Type gerericType, Annotation[] annotation) {
		// we want to check if the rawType Passes is of type MYDATE class.
		if (rawType.getName().equals(MyDate.class.getName())) {
			// if we found the object as MyDate return the converter
			// (paramConverter)
			// we can create a new converter class or inline class.
			return new ParamConverter<T>() {

				@Override
				public T fromString(String value) {
					// here the value is the param we are passing t=in the URI.
					Calendar requestedDAte = Calendar.getInstance();
					if ("tomorrow".equalsIgnoreCase(value)) {
						requestedDAte.add(Calendar.DATE, 1);
					}
					if ("yesterday".equalsIgnoreCase(value)) {
						requestedDAte.add(Calendar.DATE, -1);
					}
					MyDate date = new MyDate();
					date.setDate(requestedDAte.get(Calendar.DATE));
					date.setDate(requestedDAte.get(Calendar.MONTH));
					date.setDate(requestedDAte.get(Calendar.YEAR));

					return rawType.cast(date);
					// as its generic type we need to cast it to the object type
				}

				@Override
				public String toString(T obj) {
					if (obj == null) {
						return null;
					} else {
						return obj.toString();
					}
				}

			};
		}
		return null;
	}

}
