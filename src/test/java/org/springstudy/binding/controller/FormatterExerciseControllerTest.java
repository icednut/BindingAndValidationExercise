package org.springstudy.binding.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springstudy.Application;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;

/**
 * @author wangeun.lee@sk.com
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
public class FormatterExerciseControllerTest {
    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext context;

    @Before
    public void setUp() throws Exception {
        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

    @Test
    public void testFormatterNumber() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/formatter/number").param("price", "$192,000.00"))
                .andExpect(model().attribute("price", new BigDecimal("192000.00")));
    }

    @Test
    public void testFormatterDate() throws Exception {
        Date date = (Date) mockMvc.perform(MockMvcRequestBuilders.get("/formatter/date").param("orderDate", "2015/06/27"))
                .andReturn()
                .getModelAndView()
                .getModel()
                .get("date");

        Calendar calendar = Calendar.getInstance();

        calendar.setTime(date);
        assertThat(calendar.get(Calendar.YEAR), is(2015));
        assertThat(calendar.get(Calendar.MONTH), is(5));
        assertThat(calendar.get(Calendar.DATE), is(27));
    }

}