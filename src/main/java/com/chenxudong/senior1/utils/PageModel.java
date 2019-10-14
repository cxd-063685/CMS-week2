package com.chenxudong.senior1.utils;

import java.util.ArrayList;
import java.util.List;

public class PageModel<T> {
    //所有的查询结果
    private List<T> allList;
    //当前页需要的查询结果
    private List<T> pageList;
    //每页显示条数
    private int pagecount;
    //当前页
    private int nowpage;
    //最大页数
    private int maxpage;
    //最小页数
    private int minpage;
    //js代码
    private String pageInfo;
    //构造方法
    public PageModel(List<T> allList,int pageCount){
        this.allList = allList;
        this.pagecount = pageCount;
        //初始化最大页数
        if(allList.size() % pagecount ==0){
            this.maxpage = allList.size() / pagecount;
        }else{
            this.maxpage = allList.size() / pagecount + 1;
        }
        //初始化最小页与当前页
        this.minpage = 1;
        this.nowpage = 1;
        //设置当前页的数据
        this.changePageList(nowpage);
    }
    //设置当前页面的数据
    public void changePageList(int nowpage) {
        this.nowpage = nowpage;
        pageList = new ArrayList<>();
        for(int i = (nowpage - 1) * pagecount ; i < (nowpage*pagecount) && i < allList.size() ; i++){
            pageList.add(allList.get(i));
        }
        changePageInfo();
    }
    //前台js页面信息
    public void changePageInfo(){
        String classname = "";
        if(this.allList.size() > 0){
            Class<?> aClass = allList.get(0).getClass();
            classname = aClass.toString();
        }
        pageInfo = "";
        pageInfo += "当前第"+nowpage+"页,共"+maxpage+"页";
        pageInfo += "<button type='button' onclick=\"location='changePage.do?nowPage=1'\">首页</botton><br>";
        pageInfo += "<button type='button' onclick=\"location='changePage.do?nowPage="+(nowpage-1)+"'\">上一页</botton><br>";
        pageInfo += "<button type='button' onclick=\"location='changePage.do?nowPage="+(nowpage+1)+"'\">下一页</botton><br>";
        pageInfo += "<button type='button' onclick=\"location='changePage.do?nowPage="+(maxpage)+"'\">尾页</botton><br>";
    }
    //getter And setter
	public List<T> getAllList() {
		return allList;
	}
	public void setAllList(List<T> allList) {
		this.allList = allList;
	}
	public List<T> getPageList() {
		return pageList;
	}
	public void setPageList(List<T> pageList) {
		this.pageList = pageList;
	}
	public int getPagecount() {
		return pagecount;
	}
	public void setPagecount(int pagecount) {
		this.pagecount = pagecount;
	}
	public int getNowpage() {
		return nowpage;
	}
	public void setNowpage(int nowpage) {
		this.nowpage = nowpage;
	}
	public int getMaxpage() {
		return maxpage;
	}
	public void setMaxpage(int maxpage) {
		this.maxpage = maxpage;
	}
	public int getMinpage() {
		return minpage;
	}
	public void setMinpage(int minpage) {
		this.minpage = minpage;
	}
	public String getPageInfo() {
		return pageInfo;
	}
	public void setPageInfo(String pageInfo) {
		this.pageInfo = pageInfo;
	}
}
