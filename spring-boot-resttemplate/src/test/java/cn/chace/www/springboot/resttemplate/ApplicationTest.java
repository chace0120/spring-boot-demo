package cn.chace.www.springboot.resttemplate;

import cn.chace.www.springboot.resttemplate.entity.User;
import com.google.common.collect.Maps;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * 测试请求spring-boot-webmvc提供的rest接口
 *
 * @author chenx
 * @date 2016/3/25
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(Application.class)
public class ApplicationTest {
    @Test
    public void getUser() {
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8080/users/{id}";
        Map<String, String> params = Maps.newHashMap();
        params.put("id", "5");

        User user = restTemplate.getForObject(url, User.class, params);

        assertEquals(8, user.getId());
    }

    @Test
    public void getUsers() {
        RestTemplate restTemplate = new RestTemplate();
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
}
