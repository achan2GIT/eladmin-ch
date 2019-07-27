package me.zhengjie.security;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;

/**
 * 基于spring security 的单元测试基础类
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public abstract class SpringSecurityBaseTest {

    @Autowired
    private WebApplicationContext wac;

    public MockMvc mockMvc;
    //  private RedisServer redisServer;//嵌入式redis

    @Before
    public void setUp () {
        mockMvc = MockMvcBuilders.webAppContextSetup(wac).apply(springSecurity()).build();

        //以下这两种都要在初始化bean之前创建，早于创建UserServiceImpl.RedisService

        //方式一，host不能设置，fail
       /* try {
            redisServer = RedisServer.newRedisServer(6379);
            redisServer.start();
            String h = redisServer.getHost();//0.0.0.0
            System.out.println("内嵌redis绑定主机"+h);
            URL resource = RedisTestApplicationTests.class.getClassLoader().getResource("application.properties");
            Files.write("spring.redis.port=" + redisServer.getBindPort(), new File(resource.getFile()), StandardCharsets.UTF_8);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }*/

        //方式二：内嵌
//        redisServer = RedisServer.builder().port(6379).build();
//        redisServer.start();

    }
}
