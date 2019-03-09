package com.el.e3mall.service;


import com.el.e3mall.common.pojo.EasyUIDataGridResult;
import com.el.e3mall.pojo.TbItem;

public interface ItemService {

	TbItem getItemById(long itemId);

	EasyUIDataGridResult getItemList(Integer page, Integer rows);
}
