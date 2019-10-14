package com.chenxudong.senior1.service;

import java.util.List;

import com.chenxudong.senior1.entity.Goods;
import com.chenxudong.senior1.entity.SelectModel;

public interface GoodsService {
	//添加商品
	public int addGoods(Goods goods);
	//商品列表
	public List<Goods> listGoods(SelectModel selectModel);
}
