package cn.wfy.service.impl;

import cn.wfy.service.SellOutService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

/**
 * @Description TODO
 * @auther wfy
 * @since 2021/4/11
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SellOutServiceImplTest {
    @Autowired
    private SellOutService sellOutService;

    @Autowired
    WebApplicationContext wac;
    MockMvc mvc;

    @Test
    public void testOne() {
        sellOutService.initial();
    }

    @Test
    public void testTwo() {
        MockMvc build = MockMvcBuilders.webAppContextSetup(wac).build();
        RequestBuilder requestBuilder = get("http://127.0.0.1:9991/test/ioc");
        try {
            String contentAsString = build.perform(requestBuilder).andReturn().getResponse().getContentAsString();
            System.out.println(contentAsString);
            assert true;
            System.out.println("1111111111");
            Assert.assertEquals("1","1");
        } catch (Exception e) {
            e.printStackTrace();
        }
        sellOutService.initial();
    }

}