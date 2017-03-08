package org.springstudy.binding.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CharsetEditor;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springstudy.Application;

import java.nio.charset.Charset;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author wangeun.lee@sk.com
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
public class BindingExerciseControllerTest {
    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext context;

    @Before
    public void setUp() throws Exception {
        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

    @Test
    public void testHello() throws Exception {
        // given
        String requestMessage = "Hello World!";

        // then
        mockMvc.perform(MockMvcRequestBuilders.get("/hello").param("requestMessage", requestMessage))
                .andExpect(status().isOk())
                .andExpect(model().attribute("requestMessage", is(requestMessage)));
    }

    @Test
    public void testHelloBinding() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/helloBinding").param("charset", "UTF-8"))
                .andExpect(status().isOk());
    }

    @Test
    public void testCharsetEditor() throws Exception {
        // given
        CharsetEditor charsetEditor = new CharsetEditor();
        charsetEditor.setAsText("UTF-8");

        // then
        Object value = charsetEditor.getValue();
        assertThat(value, is(instanceOf(Charset.class)));

    }
}