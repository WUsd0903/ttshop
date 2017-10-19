package com.wsd.ttshop.web;



import com.wsd.ttshop.dto.Page;
import com.wsd.ttshop.dto.Result;
import com.wsd.ttshop.pojo.po.TbItem;
import com.wsd.ttshop.pojo.vo.TbItemCustom;
import com.wsd.ttshop.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


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
    public Result<TbItemCustom> listItems(Page page){

        return itemService.listItems(page);
    }

}
