package com.wsd.ttshop.service.impl;

import com.wsd.ttshop.dao.TbItemCustomMapper;
import com.wsd.ttshop.dao.TbItemMapper;
import com.wsd.ttshop.dto.Page;
import com.wsd.ttshop.dto.Result;
import com.wsd.ttshop.pojo.po.TbItem;
import com.wsd.ttshop.pojo.vo.TbItemCustom;
import com.wsd.ttshop.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public Result<TbItemCustom> listItems(Page page) {
        List<TbItemCustom> rows = itemDaoCustom.listItemsByPage(page);
        Long total = itemDaoCustom.countItem();
        Result<TbItemCustom> rs = new Result<TbItemCustom>();
        rs.setRows(rows);
        rs.setTotal(total);

        return rs;
    }
}
