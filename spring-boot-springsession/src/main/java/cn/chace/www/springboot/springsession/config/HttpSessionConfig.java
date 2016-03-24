package cn.chace.www.springboot.springsession.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import org.springframework.session.web.http.HeaderHttpSessionStrategy;
import org.springframework.session.web.http.HttpSessionStrategy;

/**
 * @author chenx
 * @date 2016/3/24
 */

/**
 * maxInactiveIntervalInSeconds : session过期时间（秒）
 * redisNamespace : 命名空间
 */
@EnableRedisHttpSession(maxInactiveIntervalInSeconds = 300, redisNamespace = "rsession")
@Configuration
public class HttpSessionConfig {
    /**
     * session id 存于请求头中，针对Restful方便使用
     */
//    @Bean
//    public HttpSessionStrategy httpSessionStrategy() {
//        return new HeaderHttpSessionStrategy();
//    }
}
