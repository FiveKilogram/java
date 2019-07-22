package Reflection;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Reflection {

	public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchFieldException, NoSuchMethodException, InvocationTargetException, UnsupportedEncodingException {
		Class c = Class.forName("Reflection.TT");

		c.getSuperclass().newInstance();

//		Constructor constructor = c.getDeclaredConstructor(int.class);
//		constructor.setAccessible(true);
//		constructor.newInstance(6);




		Field[] fields = c.getDeclaredFields();

		for (Field f:fields
			 ) {
			System.out.println(f);
		}

//		Method[] methods = c.getDeclaredMethods();
//
//		for (Method m:methods
//			 ) {
//			System.out.println(m);
//		}
//
//		T t = (T)c.newInstance();
//
//		Field field = c.getDeclaredField("a");
//		System.out.println(field);
//
//		Method method = c.getDeclaredMethod("d");
//		method.setAccessible(true);
//		method.invoke(t);
//
//		field.setAccessible(true);
//		field.setInt(t,5);
//
//		System.out.println(t.toString());

//		T t = new T();
//		t.setA(66);
//		t.setB(7);
//		Field field = t.getClass().getDeclaredField("b");
//		field.setAccessible(true);
//		System.out.println(field.getInt(t));

	}
}

