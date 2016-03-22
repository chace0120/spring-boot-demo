package cn.chace.www.springboot.quartz.web;

import cn.chace.www.springboot.quartz.job.QuartzJob;
import cn.chace.www.springboot.quartz.job.QuartzJobEntity;
import cn.chace.www.springboot.quartz.job.QuartzManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by PC on 2016/3/19.
 */
@RestController
public class DemoController {

    @Autowired
    QuartzManager quartzManager;

    @RequestMapping("/boot")
    public String boot() {
        return "Hello World";
    }

    @RequestMapping("/schedule")
    public String schedule() throws InterruptedException {
        QuartzJobEntity jobEntity = new QuartzJobEntity();
        jobEntity.setJobName("chace");
        jobEntity.setJobGroup("cx");
        jobEntity.setCronExpression("0/5 * * * * ?");

        quartzManager.initJob(jobEntity, QuartzJob.class);

        return "schedule successfully!";
    }

    @RequestMapping("/unschedule")
    public String unschedule() {
        QuartzJobEntity jobEntity = new QuartzJobEntity();
        jobEntity.setJobName("chace");
        jobEntity.setJobGroup("cx");

        quartzManager.deleteJob(jobEntity);

        return "unschedule successfully!";
    }
}
