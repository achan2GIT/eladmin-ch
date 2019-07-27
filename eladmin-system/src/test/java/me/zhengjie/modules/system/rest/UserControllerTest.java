package me.zhengjie.modules.system.rest;

import me.zhengjie.security.SpringSecurityBaseTest;
import me.zhengjie.security.WithMockAdminUserDetails;
import org.junit.After;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithAnonymousUser;
import org.springframework.security.test.web.servlet.response.SecurityMockMvcResultMatchers;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

/**
 * @author chen
 * 获取验证码/用户查询等api UT
 */
public class UserControllerTest extends SpringSecurityBaseTest {

    @Test
//    @WithMockAdmin
    @WithMockAdminUserDetails
    public void getUsersWithAdmin() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/users").contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    @WithAnonymousUser
    public void getUsers() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/users").contentType(MediaType.APPLICATION_JSON))
                .andExpect(SecurityMockMvcResultMatchers.unauthenticated())
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    @WithAnonymousUser
    public void geAuthVcode() throws Exception {//启动时依懒redis-server
        mockMvc.perform(MockMvcRequestBuilders.get("/auth/vCode").contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
        /**
         * TODO
         * 返回的body示例：Body = {"img":"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","uuid":"9c0f00e5d436450baebd40c260b6f7ba"}
         * 是ImgResult对象，可转换后取得uuid,然后从redis中取的对应的vCode，进入模拟登录 /auth/login 的api
         */

    }

    @After
    public void tearDown() throws Exception {
    }
}