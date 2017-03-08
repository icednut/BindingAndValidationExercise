package org.springstudy.binding.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springstudy.Application;
import org.springstudy.common.dto.Level;
import org.springstudy.common.dto.Member;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;

/**
 * @author wangeun.lee@sk.com
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
public class InitBinderExerciseControllerTest {
    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext context;

    @Before
    public void setUp() throws Exception {
        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

    @Test
    public void testLevel() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/level").param("level", String.valueOf(1)))
                .andExpect(model().attribute("level", Level.BASIC));
    }

    @Test
    public void testMinMax() throws Exception {
        MockHttpServletRequestBuilder param = MockMvcRequestBuilders.get("/minMax")
                .param("id", String.valueOf(1))
                .param("age", String.valueOf(1412));

        Member member = (Member) mockMvc.perform(param)
                .andReturn()
                .getModelAndView()
                .getModel()
                .get("member");

        assertThat(member.getAge(), is(200));
    }
}