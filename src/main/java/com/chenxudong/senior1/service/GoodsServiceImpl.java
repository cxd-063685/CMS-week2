package com.chenxudong.senior1.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chenxudong.senior1.entity.Goods;
import com.chenxudong.senior1.entity.SelectModel;
import com.chenxudong.senior1.mapper.GoodsMapper;

@Service
public class GoodsServiceImpl implements GoodsService{
	//service实现类
	@Autowired
	private GoodsMapper dao;
	//添加商品
	@Override
	public int addGoods(Goods goods) {
		// TODO Auto-generated method stub
		return dao.addGoods(goods);
	}
	//商品列表
	@Override
	public List<Goods> listGoods(SelectModel selectModel) {
		// TODO Auto-generated method stub
		return dao.listGoods(selectModel);
	}
	
	
}
