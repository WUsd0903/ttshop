package com.wsd.ttshop.service;

import com.wsd.ttshop.dto.Page;
import com.wsd.ttshop.dto.Result;
import com.wsd.ttshop.pojo.po.TbItem;
import com.wsd.ttshop.pojo.vo.TbItemCustom;

public interface ItemService {

    TbItem getById(Long itemId);
    //List<TbItem> listItems();
    Result<TbItemCustom> listItems(Page page);
}
