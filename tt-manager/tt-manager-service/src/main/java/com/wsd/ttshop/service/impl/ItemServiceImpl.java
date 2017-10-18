package com.wsd.ttshop.service.impl;

import com.wsd.ttshop.dao.TbItemMapper;
import com.wsd.ttshop.pojo.po.TbItem;
import com.wsd.ttshop.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemServiceImpl implements ItemService{

    @Autowired
    private TbItemMapper itemDao;
    @Override
    public TbItem getById(Long itemId) {
        return itemDao.selectByPrimaryKey(itemId);
    }
}
