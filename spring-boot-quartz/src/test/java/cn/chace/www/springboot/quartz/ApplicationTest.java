package cn.chace.www.springboot.quartz;

import cn.chace.www.springboot.quartz.config.QuartzConfig;
import cn.chace.www.springboot.quartz.job.QuartzJob;
import cn.chace.www.springboot.quartz.job.QuartzJobEntity;
import cn.chace.www.springboot.quartz.job.QuartzManager;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by chace on 2016/3/22.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(Application.class)
public class ApplicationTest {
    @Autowired
    QuartzManager quartzManager;

    @Test
    public void addJob() {
        QuartzJobEntity jobEntity = new QuartzJobEntity();
        jobEntity.setJobName("chace");
        jobEntity.setJobGroup("chaceGroup");
        jobEntity.setCronExpression("0/5 * * * * ?"); //每隔5秒重复job

        quartzManager.initJob(jobEntity, QuartzJob.class);

        try {
            Thread.sleep(10000); //睡眠一分钟，查看任务结果
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void deleteJob() {
        QuartzJobEntity jobEntity = new QuartzJobEntity();
        jobEntity.setJobName("chace");
        jobEntity.setJobGroup("chaceGroup");
        jobEntity.setCronExpression("0/5 * * * * ?"); //每隔5秒重复job

        quartzManager.initJob(jobEntity, QuartzJob.class);

        try {
            Thread.sleep(10000); //睡眠一分钟，查看任务结果
            quartzManager.deleteJob(jobEntity);
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
