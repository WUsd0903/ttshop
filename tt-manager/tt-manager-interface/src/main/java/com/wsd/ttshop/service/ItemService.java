package com.wsd.ttshop.service;

import com.wsd.ttshop.dto.Order;
import com.wsd.ttshop.dto.Page;
import com.wsd.ttshop.dto.Result;
import com.wsd.ttshop.pojo.po.TbItem;
import com.wsd.ttshop.pojo.vo.TbItemCustom;

import java.util.List;

public interface ItemService {

    TbItem getById(Long itemId);
    //List<TbItem> listItems();
    Result<TbItemCustom> listItems(Page page, Order order);
    int updateItemByIds(List<Long> ids);
    int updateItemByIdsUp(List<Long> ids);
    int updateItemByIdsDown(List<Long> ids);

}
