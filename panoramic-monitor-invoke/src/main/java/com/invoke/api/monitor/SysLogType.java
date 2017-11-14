package com.invoke.api.monitor;

/**
 * @author summer
 */
public enum SysLogType {
    asynchTask("异步任务队列"),
    userlogin("用户登录"),
    reqStats("Request请求统计日志"),
    SMSERR("短信发送失败"),
    order("订单日志"),
    hitCache("命中座位缓存"),
    useElecCard("使用电子券"),
    monitor("监控数据"),
    smswarn("报警短信"),
    terminalLog("终端监控日志"),
    openapiLog("openapi监控日志"),
    userOp("用户重要操作"),
    saOp("SA动作");

    private String description;

    private SysLogType(String description) {
        this.description = description;
    }

    public String getDescription() {
        return this.description;
    }
}
