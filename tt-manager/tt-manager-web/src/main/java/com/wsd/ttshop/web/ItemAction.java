package com.wsd.ttshop.web;



import com.wsd.ttshop.dto.Order;
import com.wsd.ttshop.dto.Page;
import com.wsd.ttshop.dto.Result;
import com.wsd.ttshop.pojo.po.TbItem;
import com.wsd.ttshop.pojo.vo.TbItemCustom;
import com.wsd.ttshop.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@Scope("prototype")
public class ItemAction {

    @Autowired
    private ItemService itemService;

    @ResponseBody
    @RequestMapping(value = "/item/{itemId}",method = RequestMethod.GET)
    public TbItem getById(@PathVariable Long itemId){

        return itemService.getById(itemId);
    }

/*    @ResponseBody
    @RequestMapping("/items")
    public List<TbItem> listItems(){

        return itemService.listItems();
    }*/

    @ResponseBody
    @RequestMapping("/items")
    public Result<TbItemCustom> listItems(Page page,Order order){
        return itemService.listItems(page,order);
    }


    @ResponseBody
    @RequestMapping(value = "/items/batch",method = RequestMethod.POST)
    public int updateItemByIds(@RequestParam("ids[]") List<Long> ids) {
        return itemService.updateItemByIds(ids);
    }


    @ResponseBody
    @RequestMapping(value = "/items/up",method = RequestMethod.POST)
    public int updateItemByIdsUp(@RequestParam("ids[]") List<Long> ids) {
        return itemService.updateItemByIdsUp(ids);
    }


    @ResponseBody
    @RequestMapping(value = "/items/down",method = RequestMethod.POST)
    public int updateItemByIdsDown(@RequestParam("ids[]") List<Long> ids) {
        return itemService.updateItemByIdsDown(ids);
    }
}


