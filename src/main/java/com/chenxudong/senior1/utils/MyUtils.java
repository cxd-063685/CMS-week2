package com.chenxudong.senior1.utils;

import java.util.Calendar;
import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class MyUtils {
	
	private MyUtils(){}
	
	//判断源字符串是否有值，空引号和空格也算没值。
	public static boolean hasText(String txt){
		if(txt != null && txt.trim().length() > 0){
			return true;
		}else{
			return false;
		}
	}
	
	//该方法是判断参数是否为数字，包含小数，
	public static boolean isNumber(String str){
		try {
			double num = Double.parseDouble(str);
		} catch (NumberFormatException e) {
			return false;
		}
		return true;
	}
	
	//根据生日计算年龄功能，输入任意一个生日，返回至今天的年龄整数
	public static int getAge(Date birthday){
		Calendar c = Calendar.getInstance();
		c.setTime(birthday);
		return Calendar.getInstance().get(Calendar.YEAR) - c.get(Calendar.YEAR);
	}
}
