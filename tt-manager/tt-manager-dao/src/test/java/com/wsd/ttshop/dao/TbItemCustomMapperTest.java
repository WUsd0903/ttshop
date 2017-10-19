package com.wsd.ttshop.dao;

import com.wsd.ttshop.dto.Page;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao-test.xml"})
public class TbItemCustomMapperTest {

    @Autowired
    private TbItemCustomMapper itemDaoCustom;
    @Test
    public void listItemsByPage() throws Exception {
        Page page = new Page();
        page.setRows(10);
        page.setPage(1);
        System.out.println(itemDaoCustom.listItemsByPage(page).size());
    }

    @Test
    public void countItem() throws Exception {
        System.out.println(itemDaoCustom.countItem());

    }

}