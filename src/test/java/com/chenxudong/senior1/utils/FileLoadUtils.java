package com.chenxudong.senior1.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.ArrayList;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.support.XmlWebApplicationContext;

import com.chenxudong.senior1.entity.Goods;
import com.chenxudong.senior1.mapper.GoodsMapper;

public class FileLoadUtils {
	
	public static void main(String[] args) throws IOException {
		//使用spring获取mapper的实现类
		ApplicationContext c = new ClassPathXmlApplicationContext("spring.xml");
		GoodsMapper mapper = c.getBean(GoodsMapper.class,"goodsMapper");
		//创建IO流
		InputStream in = FileLoadUtils.class.getClassLoader().getResourceAsStream("data.txt");
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		String str = "";
		//按行读取数据文件
		while((str = br.readLine())!= null){
			String[] data = str.split("==");
			Goods goods = new Goods();
			//ID值要使用isNumber()工具方法判断是不是数字
			if(MyUtils.isNumber(data[0]) && data.length >= 1){
				goods.setGid(Integer.parseInt(data[0]));
			}else{
				goods.setGid(0);
			}
			//商品名称要使用hasText()方法判断有没有值
			if(MyUtils.hasText(data[1]) && data.length >= 2){
				goods.setGname(data[1]);
			}else{
				goods.setGname("无名称");
			}
			//价格要使用hasText()方法判断有没有值，并使用isNumber()判断是不是数字（不是数字的可以手工处理好再解析）
			if(MyUtils.hasText(data[2]) && MyUtils.isNumber(data[2].replace("¥", "")) && data.length >= 3){
				goods.setPrice(BigDecimal.valueOf(Double.parseDouble(data[2].replace("¥", ""))));
			}else{
				goods.setPrice(BigDecimal.valueOf(0.0));
			}
			//添加售卖百分比
			if(data.length >= 4){
				goods.setPrint(Integer.parseInt(data[3].replace("%", "")));
			}else{
				goods.setPrint(0);
			}
			System.out.println(goods);
			mapper.addGoods(goods);
		}
	}
}
