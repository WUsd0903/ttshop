package com.wsd.ttshop.dao;

import com.wsd.ttshop.dto.Page;
import com.wsd.ttshop.pojo.vo.TbItemCustom;

import java.util.List;

public interface TbItemCustomMapper {

    List<TbItemCustom> listItemsByPage(Page page);

    Long countItem();
}
