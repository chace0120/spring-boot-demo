package cn.chace.www.springboot.quartz.job;

/**
 * Created by chace on 2016/3/21.
 */
public class QuartzJobEntity {
    private Integer jobId;
    private String jobName;
    private String jobGroup;
    /**
     * 任务状态 0:禁用 1:启用 2:删除
     */
    private Integer jobStatus;
    private String cronExpression;

    public Integer getJobId() {
        return jobId;
    }

    public void setJobId(Integer jobId) {
        this.jobId = jobId;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public String getJobGroup() {
        return jobGroup;
    }

    public void setJobGroup(String jobGroup) {
        this.jobGroup = jobGroup;
    }

    public Integer getJobStatus() {
        return jobStatus;
    }

    public void setJobStatus(Integer jobStatus) {
        this.jobStatus = jobStatus;
    }

    public String getCronExpression() {
        return cronExpression;
    }

    public void setCronExpression(String cronExpression) {
        this.cronExpression = cronExpression;
    }
}
