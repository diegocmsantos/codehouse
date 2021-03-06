package com.clearbases.codehouse.controllers;

import com.clearbases.codehouse.conf.AppWebConfiguration;
import com.clearbases.codehouse.conf.JPAConfiguration;
import com.clearbases.codehouse.conf.SecurityConfiguration;
import com.clearbases.codehouse.confs.DataSourceConfigurationTest;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import javax.servlet.Filter;

/**
 * Created by diego on 6/18/17.
 */
@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {
        JPAConfiguration.class,
        AppWebConfiguration.class,
        DataSourceConfigurationTest.class,
        SecurityConfiguration.class}
)
@ActiveProfiles("test")
public class ProductControllerTest {

    @Autowired
    private WebApplicationContext wac;

    @Autowired
    private Filter springSecurityFilterChain;

    private MockMvc mockMvc;

    @Before
    public void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(wac).addFilter(springSecurityFilterChain).build();
    }

    @Test
    public void shouldReturnHomePageWithBooks() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/"))
                .andExpect(MockMvcResultMatchers.model().attributeExists("products"))
                .andExpect(MockMvcResultMatchers.forwardedUrl("/WEB-INF/views/home.jsp"));
    }

    @Test
    public void shouldOnlyAdminRoleAccessProductsForm() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/products/form")
                .with(SecurityMockMvcRequestPostProcessors
                        .user("user@casadocodigo.com.br").password("123456")
                        .roles("USUARIO")))
                .andExpect(MockMvcResultMatchers.status().is(403));
    }

}
