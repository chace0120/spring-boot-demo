package cn.chace.www.springboot.quartz.config;

import cn.chace.www.springboot.quartz.job.AutoWiringSpringBeanJobFactory;
import cn.chace.www.springboot.quartz.job.QuartzManager;
import org.quartz.spi.JobFactory;
import org.springframework.beans.factory.config.PropertiesFactoryBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

import java.io.IOException;
import java.util.Properties;

/**
 * Created by chace on 2016/3/22.
 */
@Configuration
@ConditionalOnProperty(name="quartz.enabled")
public class QuartzConfig {
    @Bean
    public JobFactory autoWiringSpringBeanJobFactory(ApplicationContext applicationContext) {
        AutoWiringSpringBeanJobFactory autoWiringSpringBeanJobFactory = new AutoWiringSpringBeanJobFactory();
        autoWiringSpringBeanJobFactory.setApplicationContext(applicationContext);

        return autoWiringSpringBeanJobFactory;
    }

    @Bean
    public Properties quartzProperties() throws IOException {
        PropertiesFactoryBean propertiesFactoryBean = new PropertiesFactoryBean();
        propertiesFactoryBean.setLocation(new ClassPathResource("/quartz.properties"));
        propertiesFactoryBean.afterPropertiesSet();

        return propertiesFactoryBean.getObject();
    }

    @Bean
    public SchedulerFactoryBean schedulerFactoryBean(JobFactory jobFactory) throws IOException {
        SchedulerFactoryBean schedulerFactoryBean = new SchedulerFactoryBean();
        schedulerFactoryBean.setJobFactory(jobFactory);
        schedulerFactoryBean.setQuartzProperties(quartzProperties());


        return schedulerFactoryBean;
    }

    @Bean(initMethod = "init")
    public QuartzManager getQuartzManager(SchedulerFactoryBean schedulerFactoryBean) {
        return new QuartzManager(schedulerFactoryBean);
    }
}
