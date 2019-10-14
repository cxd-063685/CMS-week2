package com.chenxudong.senior1.entity;

public class SelectModel {
	//搜索用字段
	private String pricebegin;
	private String priceend;
	private String printbegin;
	private String printend;
	private String sortby;
	private String sortto;
	
	
	public SelectModel(){
		pricebegin = "";
		priceend = "";
		printbegin = "";
		printend = "";
		sortby = "";
		sortto = "";
	}
	public String getPricebegin() {
		return pricebegin;
	}
	public void setPricebegin(String pricebegin) {
		this.pricebegin = pricebegin;
	}
	public String getPriceend() {
		return priceend;
	}
	public void setPriceend(String priceend) {
		this.priceend = priceend;
	}
	public String getPrintbegin() {
		return printbegin;
	}
	public void setPrintbegin(String printbegin) {
		this.printbegin = printbegin;
	}
	public String getPrintend() {
		return printend;
	}
	public void setPrintend(String printend) {
		this.printend = printend;
	}
	public String getSortby() {
		return sortby;
	}
	public void setSortby(String sortby) {
		this.sortby = sortby;
	}
	public String getSortto() {
		return sortto;
	}
	public void setSortto(String sortto) {
		this.sortto = sortto;
	}
	
	
}	
