package com.el.e3mall.pageHelper;

import com.el.e3mall.mapper.TbItemMapper;
import com.el.e3mall.pojo.TbItem;
import com.el.e3mall.pojo.TbItemExample;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * @Auther: roman.zhang
 * @Date: 2019/3/9 15:53
 * @Version:V1.0
 * @Description:PageHelperTest
 */
public class PageHelperTest {

    @Test
    public void test(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring/applicationContext-dao.xml");

        //从spring容器中获取TbItemMapper对象
        TbItemMapper itemMapper = applicationContext.getBean(TbItemMapper.class);

        //设置分页信息
        PageHelper.startPage(1,10);

        TbItemExample itemExample = new TbItemExample();

        List<TbItem> tbItems = itemMapper.selectByExample(itemExample);

        PageInfo<TbItem> tbItemPageInfo = new PageInfo<>(tbItems);

        //取分页信息
        System.out.println("总记录数："+tbItemPageInfo.getTotal());
        System.out.println("总页数："+tbItemPageInfo.getPages());
        System.out.println("当前页码："+tbItems.size());
    }
}
