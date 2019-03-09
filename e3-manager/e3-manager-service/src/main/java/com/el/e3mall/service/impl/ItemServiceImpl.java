package com.el.e3mall.service.impl;

import java.util.List;

import com.el.e3mall.common.pojo.EasyUIDataGridResult;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.el.e3mall.mapper.TbItemMapper;
import com.el.e3mall.pojo.TbItem;
import com.el.e3mall.pojo.TbItemExample;
import com.el.e3mall.pojo.TbItemExample.Criteria;
import com.el.e3mall.service.ItemService;

/**
 * 商品管理Service
 * <p>Title: ItemServiceImpl</p>
 * <p>Description: </p>
 * @version 1.0
 */
@Service
public class ItemServiceImpl implements ItemService {

	@Autowired
	private TbItemMapper itemMapper;
	
	@Override
	public TbItem getItemById(long itemId) {
		//根据主键查询
		TbItem tbItem = itemMapper.selectByPrimaryKey(itemId);
		return tbItem;
		/*TbItemExample example = new TbItemExample();
		Criteria criteria = example.createCriteria();
		//设置查询条件
		criteria.andIdEqualTo(itemId);
		//执行查询
		List<TbItem> list = itemMapper.selectByExample(example);
		if (list != null && list.size() > 0) {
			return list.get(0);
		}
		return null;*/
	}

	@Override
	public EasyUIDataGridResult getItemList(Integer page, Integer rows) {
		//设置分页信息
		PageHelper.startPage(page,rows);
		//执行查询结果
		TbItemExample tbItemExample = new TbItemExample();
		List<TbItem> tbItems = itemMapper.selectByExample(tbItemExample);
		//创建一个空的，返回对象
		EasyUIDataGridResult easyUIDataGridResult = new EasyUIDataGridResult();
		easyUIDataGridResult.setRows(tbItems);
		//取分页结果
		PageInfo<TbItem> tbItemPageInfo = new PageInfo<>(tbItems);
		long total = tbItemPageInfo.getTotal();
		easyUIDataGridResult.setTotal(total);
		return easyUIDataGridResult;
	}

}
