package com.chenxudong.senior1.test;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.Test;

import com.chenxudong.senior1.utils.MyUtils;

public class TestCase {

	
	@Test
	public void test1() throws ParseException{
		//测试hasText方法
		System.out.println(MyUtils.hasText(" "));
		System.out.println(MyUtils.hasText(null));
		System.out.println(MyUtils.hasText("1"));
		//测试isNumber方法
		System.out.println(MyUtils.isNumber("1s3"));
		System.out.println(MyUtils.isNumber("123"));
		System.out.println(MyUtils.isNumber("25.9"));
		//测试getAge方法
		System.out.println(MyUtils.getAge(new SimpleDateFormat("yyyy-MM-dd").parse("2001-05-04")));
		System.out.println(MyUtils.getAge(new SimpleDateFormat("yyyy-MM-dd").parse("2009-05-04")));
	}
}
