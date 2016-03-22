package cn.chace.www.springboot.webmvc.config;

import cn.chace.www.springboot.webmvc.web.filter.AuthFilter;
import cn.chace.www.springboot.webmvc.web.interceptor.LoginingInterceptor;
import org.springframework.boot.context.embedded.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by chace on 2016/3/22.
 */
@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        super.addInterceptors(registry);
        registry.addInterceptor(new LoginingInterceptor()).addPathPatterns("/demo/**");
    }

    //<editor-fold desc="Filter Definition">
    @Bean
    public FilterRegistrationBean filterRegistrationBean() {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setFilter(new AuthFilter());
        filterRegistrationBean.setName("AuthFilter");
        filterRegistrationBean.addUrlPatterns("/demo/*");

        return filterRegistrationBean;
    }
    //</editor-fold>
}
