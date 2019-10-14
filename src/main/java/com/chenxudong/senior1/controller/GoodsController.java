package com.chenxudong.senior1.controller;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.chenxudong.senior1.entity.Goods;
import com.chenxudong.senior1.entity.SelectModel;
import com.chenxudong.senior1.service.GoodsService;
import com.chenxudong.senior1.utils.PageModel;

@Controller
public class GoodsController {
	@Autowired
	private GoodsService service;
	//列表
	@RequestMapping("list.do")
	public ModelAndView listGoods(HttpSession session,SelectModel selectModel){
		ModelAndView mav = new ModelAndView();
		Map<String,String> map = new HashMap<String,String>();
		List<Goods> listGoods = service.listGoods(selectModel);
		//sortListGoods(selectModel, listGoods);
		PageModel<Goods> pm = new PageModel<Goods>(listGoods,4);
		session.setAttribute("pm", pm);
		mav.getModelMap().addAttribute("list",pm);
		session.setAttribute("selectModel",selectModel);
		mav.setViewName("list");
		return mav;
	}
	//为集合排序
	private void sortListGoods(SelectModel selectModel, List<Goods> listGoods) {
		if(selectModel.getSortby().equals("价格")){
			listGoods.sort((g1,g2)->g1.getPrice().compareTo(g2.getPrice()));
		}else if(selectModel.getSortby().equals("已售百分比")){
			listGoods.sort((g1,g2)->g1.getPrint()-(g2.getPrint()));
		}
		
		if(selectModel.getSortto().equals("倒序")){
			Collections.reverse(listGoods);
		}
	}
	
	//翻页
	@RequestMapping("changePage.do")
	public ModelAndView changePage(HttpSession session,String nowPage){
		ModelAndView mav = new ModelAndView();
		@SuppressWarnings("unchecked")
		PageModel<Goods> pm =(PageModel<Goods>) session.getAttribute("pm");
		pm.changePageList(Integer.parseInt(nowPage));
		mav.getModelMap().addAttribute("list",pm);
		mav.setViewName("list");
		return mav;
	}
}
