package com.wsd.ttshop.dao;

import com.wsd.ttshop.pojo.vo.TbItemCustom;

import java.util.List;
import java.util.Map;

public interface TbItemCustomMapper {

    List<TbItemCustom> listItemsByPage(Map<String,Object> map);

    Long countItem();
    int updateItemByIds(List<Long> ids);
}
