package com.chenxudong.senior1.entity;

import java.math.BigDecimal;

public class Goods {
//	编写一个Goods商品类，共有ID，商品名称，商品价格，已售百分比，共4个属性。
//	其中价格需要为BigDecimal类型。如果不是，则4分全扣。
	private int gid;
	private String gname;
	private BigDecimal price;
	private int print;
	
	@Override
	public String toString() {
		return "Goods [gid=" + gid + ", gname=" + gname + ", price=" + price + ", print=" + print + "]";
	}
	public int getGid() {
		return gid;
	}
	public void setGid(int gid) {
		this.gid = gid;
	}
	public String getGname() {
		return gname;
	}
	public void setGname(String gname) {
		this.gname = gname;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public int getPrint() {
		return print;
	}
	public void setPrint(int print) {
		this.print = print;
	}
	public Goods(int gid, String gname, BigDecimal price, int print) {
		super();
		this.gid = gid;
		this.gname = gname;
		this.price = price;
		this.print = print;
	}
	public Goods() {
		super();
	}
	
	
	
	
}
