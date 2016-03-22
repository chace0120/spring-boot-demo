package cn.chace.www.springboot.quartz.job;

import org.quartz.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

/**
 * Created by chace on 2016/3/21.
 */
public class QuartzManager {
    private static final Logger LOGGER = LoggerFactory.getLogger(QuartzManager.class);

    private SchedulerFactoryBean schedulerFactoryBean;

    private Scheduler scheduler;

    public QuartzManager(SchedulerFactoryBean schedulerFactoryBean) {
        this.schedulerFactoryBean = schedulerFactoryBean;
    }

    public void init() {
        this.scheduler = this.schedulerFactoryBean.getScheduler();
    }

    public void initJob(QuartzJobEntity job, Class cls) {
        LOGGER.info("初始化任务调度");
        TriggerKey triggerKey = TriggerKey.triggerKey(job.getJobName(), job.getJobGroup());
        try {
            CronTrigger trigger = (CronTrigger) scheduler.getTrigger(triggerKey);
            if (null == trigger) {
                addQuartzJob(job, cls);
            }
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }

    private void addQuartzJob(QuartzJobEntity job, Class cls) {
        LOGGER.info("新增定时任务");
        JobDetail jobDetail = JobBuilder.newJob(cls)
                .withIdentity(job.getJobName(), job.getJobGroup()).build();
        CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(job.getCronExpression());
        CronTrigger trigger = TriggerBuilder.newTrigger().withIdentity(job.getJobName(), job.getJobGroup())
                .withSchedule(scheduleBuilder).build();
        try {
            scheduler.scheduleJob(jobDetail, trigger);
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }

    void runJob(QuartzJobEntity job) {
        LOGGER.info("立即运行定时任务");
        if (null == job) {
            LOGGER.info("定时任务信息为空");
            return;
        }

        JobKey jobKey = JobKey.jobKey(job.getJobName(), job.getJobGroup());
        if (null == jobKey) {
            LOGGER.info("任务调度中不存在该定时任务");
            return;
        }

        try {
            scheduler.triggerJob(jobKey);
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }

    void updateQuartzJob(QuartzJobEntity job, TriggerKey triggerKey, CronTrigger trigger) {
        LOGGER.info("修改任务调度中的定时任务");
        if (null == job || null == triggerKey || null == trigger) {
            LOGGER.info("参数异常");
            return;
        }

        LOGGER.info("原始任务表达式:" + trigger.getCronExpression() + "，现在任务表达式:" + job.getCronExpression());
        if (trigger.getCronExpression().equals(job.getCronExpression())) {
            LOGGER.info("任务调度表达式一致，不予进行修改");
            return;
        }

        CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(job.getCronExpression());
        trigger = trigger.getTriggerBuilder().withIdentity(triggerKey).withSchedule(scheduleBuilder).build();

        try {
            scheduler.rescheduleJob(triggerKey, trigger);
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }

    void pauseJob(QuartzJobEntity job) {
        LOGGER.info("暂停任务调度中的定时任务");
        if (null == job) {
            LOGGER.info("参数异常");
            return;
        }

        JobKey jobKey = JobKey.jobKey(job.getJobName(), job.getJobGroup());
        if (null == jobKey) {
            LOGGER.info("任务调度中不存在该定时任务");
            return;
        }

        try {
            scheduler.pauseJob(jobKey);
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }

    void resumeJob(QuartzJobEntity job) {
        LOGGER.info("恢复任务调度中的定时任务");
        if (null == job) {
            LOGGER.info("参数异常");
            return;
        }

        JobKey jobKey = JobKey.jobKey(job.getJobName(), job.getJobGroup());
        if (null == jobKey) {
            LOGGER.info("任务调度中不存在该定时任务");
            return;
        }

        try {
            scheduler.resumeJob(jobKey);
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }

    public void deleteJob(QuartzJobEntity job) {
        LOGGER.info("删除任务调度中的定时任务");

        if (null == job) {
            LOGGER.info("参数异常");
            return;
        }

        JobKey jobKey = JobKey.jobKey(job.getJobName(), job.getJobGroup());
        if (null == jobKey) {
            LOGGER.info("任务调度中不存在该定时任务");
            return;
        }

        try {
            scheduler.deleteJob(jobKey);
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }

    void deleteTrigger(TriggerKey triggerKey) {
        LOGGER.info("删除任务调度定时器");

        if (null == triggerKey) {
            LOGGER.info("参数异常");
            return;
        }

        try {
            scheduler.pauseTrigger(triggerKey);
            scheduler.unscheduleJob(triggerKey);
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }
}
