package com.wsd.ttshop.service.impl;

import com.wsd.ttshop.dao.TbItemCustomMapper;
import com.wsd.ttshop.dao.TbItemMapper;
import com.wsd.ttshop.dto.Order;
import com.wsd.ttshop.dto.Page;
import com.wsd.ttshop.dto.Result;
import com.wsd.ttshop.pojo.po.TbItem;
import com.wsd.ttshop.pojo.po.TbItemExample;
import com.wsd.ttshop.pojo.vo.TbItemCustom;
import com.wsd.ttshop.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ItemServiceImpl implements ItemService{

    @Autowired
    private TbItemMapper itemDao;

    @Autowired
    private TbItemCustomMapper itemDaoCustom;

    @Override
    public TbItem getById(Long itemId) {
        return itemDao.selectByPrimaryKey(itemId);
    }

    @Override
    public Result<TbItemCustom> listItems(Page page, Order order) {
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("page",page);
        map.put("order",order);
        List<TbItemCustom> rows = itemDaoCustom.listItemsByPage(map);
        Long total = itemDaoCustom.countItem();
        Result<TbItemCustom> rs = new Result<TbItemCustom>();
        rs.setRows(rows);
        rs.setTotal(total);
        return rs;
    }

    @Override
    public int updateItemByIds(List<Long> ids) {
        TbItem item = new TbItem();
        item.setStatus((byte)3);
        TbItemExample example = new TbItemExample();
        TbItemExample.Criteria criteria = example.createCriteria();
        criteria.andIdIn(ids);
        return itemDao.updateByExampleSelective(item,example);
    }

    @Override
    public int updateItemByIdsUp(List<Long> ids) {
        TbItem item = new TbItem();
        item.setStatus((byte)1);
        TbItemExample example = new TbItemExample();
        TbItemExample.Criteria criteria = example.createCriteria();
        criteria.andIdIn(ids);
        return itemDao.updateByExampleSelective(item,example);
    }

    @Override
    public int updateItemByIdsDown(List<Long> ids) {
        TbItem item = new TbItem();
        item.setStatus((byte)2);
        TbItemExample example = new TbItemExample();
        TbItemExample.Criteria criteria = example.createCriteria();
        criteria.andIdIn(ids);
        return itemDao.updateByExampleSelective(item,example);
    }

}
