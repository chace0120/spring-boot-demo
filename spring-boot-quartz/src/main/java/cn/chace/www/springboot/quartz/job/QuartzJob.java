package cn.chace.www.springboot.quartz.job;

import cn.chace.www.springboot.quartz.service.TaskService;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by chace on 2016/3/21.
 */
public class QuartzJob implements Job {

    @Autowired
    private TaskService taskService;

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        taskService.showMsg();
    }
}
