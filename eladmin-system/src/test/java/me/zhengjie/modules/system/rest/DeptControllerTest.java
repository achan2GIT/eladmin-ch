package me.zhengjie.modules.system.rest;

import me.zhengjie.security.SpringSecurityBaseTest;
import me.zhengjie.security.WithMockAdminUserDetails;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

/**
 * @author chen
 * 部门相关api UT
 */
public class DeptControllerTest extends SpringSecurityBaseTest {

    @Test
    @WithMockAdminUserDetails
    public void getDepts() throws Exception{
       mockMvc.perform(MockMvcRequestBuilders.get("/api/dept").contentType(MediaType.APPLICATION_JSON_UTF8))
               .andExpect(MockMvcResultMatchers.status().isOk())
               .andDo(MockMvcResultHandlers.print());
    }
}