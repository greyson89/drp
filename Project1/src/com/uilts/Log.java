package com.uilts;

public class Log {

	public static void info(Object clazz,String val){
		
		String  temp=clazz.getClass().getSimpleName();
		StringBuffer result = new StringBuffer();
		result.append(temp);
		result.append(" => ");
		result.append(val);
		System.out.println(result);
	}
	
	public static void info(String s,String val){
		
		StringBuffer result = new StringBuffer();
		result.append(s);
		result.append(" => ");
		result.append(val);
		System.out.println(result);
	}
	
}
