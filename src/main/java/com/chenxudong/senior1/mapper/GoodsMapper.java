package com.chenxudong.senior1.mapper;

import java.util.List;
import java.util.Map;

import com.chenxudong.senior1.entity.Goods;
import com.chenxudong.senior1.entity.SelectModel;

public interface GoodsMapper {
	//添加商品
	public int addGoods(Goods goods);
	//商品列表
	public List<Goods> listGoods(SelectModel selectModel);
}
