package com.cloud.task;

import javax.persistence.*;

/**
 * @author summer
 */
@Table(name = "schedule_triggers")
public class ScheduleTrigger {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    //时间表达式
    @Column
    private String cron;
    //使用状态 0：禁用   1：启用
    private String status;
    //任务名称
    private String jobName;
    //任务分组
    private String jobGroup;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCron() {
        return cron;
    }

    public void setCron(String cron) {
        this.cron = cron;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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


}
