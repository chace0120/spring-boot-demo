package cn.chace.www.springboot.resttemplate;

import cn.chace.www.springboot.resttemplate.component.XmlRestClient;
import cn.chace.www.springboot.resttemplate.entity.User;
import cn.chace.www.springboot.resttemplate.entity.gocanvas.CanvasResult;
import com.google.common.collect.Maps;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * 测试请求spring-boot-webmvc提供的rest接口
 *
 * @author chenx
 * @date 2016/3/25
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTest {
    @Autowired
    RestTemplate restTemplate;
    @Autowired
    private XmlRestClient restClient;

    @Test
    public void readGoCanvasApi() {
        String url = "https://www.gocanvas.com/apiv2/submissions.xml?username=xxx&password=xxx&response_id=06581301-D9BC-444C-8120-6B65C64BAA64";
        System.out.println(restClient.getForObject(url, null, CanvasResult.class, new HashMap<String, String>()).toString());
    }

    @Test
    public void getUser() {
        String url = "http://localhost:8080/users/{id}";
        Map<String, String> params = Maps.newHashMap();
        params.put("id", "5");

        User user = restTemplate.getForObject(url, User.class, params);

        assertEquals(5, user.getId());
    }

    @Test
    public void getUsers() {
        String url = "http://localhost:8080/users";

        ParameterizedTypeReference<List<User>> responseType = new ParameterizedTypeReference<List<User>>() {
        };

        ResponseEntity<List<User>> responseEntity = restTemplate.exchange(url, HttpMethod.GET, null, responseType);
        List<User> users = responseEntity.getBody();

        assertEquals(3, users.size());
        assertEquals("A", users.get(0).getName());
        assertEquals("B", users.get(1).getName());
        assertEquals("C", users.get(2).getName());
    }

    @Test
    public void mutiThreadReadTest() throws InterruptedException {
        Thread threadA = new Thread(new ReadTask());
        Thread threadB = new Thread(new ReadTask());
        Thread threadC = new Thread(new ReadTask());
        Thread threadD = new Thread(new ReadTask());

        threadA.start();
        threadB.start();
        threadC.start();
        threadD.start();

        Thread.sleep(20000);
    }

    /**
     * 模拟多线程环境下的RestTemplate单例应用
     */
    class ReadTask implements Runnable {
        @Override
        public void run() {
            System.out.println("==== 开始时间：" + new Date() + " " + Thread.currentThread().getName());

            String url = "http://localhost:8080/users/{id}";
            Map<String, String> params = Maps.newHashMap();
            params.put("id", "5");

            User user = restTemplate.getForObject(url, User.class, params);

            System.out.println("==== 完成时间：读取用户ID为" + user.getId() + " " + Thread.currentThread().getName());
        }
    }
}
