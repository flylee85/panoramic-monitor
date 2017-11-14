package com.invoke.api.monitor;

import com.invoke.model.monitor.MonitorEntry;

import java.io.Serializable;
import java.util.Map;

/**
 * @author summer
 * 监控服务接口
 */
public interface MonitorService {
    String KEY_TABLENAME = "TABLE_NAME";
    String KEY_HEXID = "HEXID";

    void addMonitorEntry(String var1, Map<String, String> var2);

    void addMonitorEntry(MonitorEntry var1);

    Map<String, String> getMonitorStatus();

    void saveChangeLog(Long var1, Class var2, Serializable var3, Map var4);

    void saveSysChangeLog(Class var1, Serializable var2, Map var3);

    void saveDelLog(Long var1, Serializable var2, Object var3);

    void saveAddLog(Long var1, Class var2, Serializable var3, Object var4);

    void saveMemberLogMap(Long var1, String var2, Map<String, String> var3, String var4);

    void saveMemberLog(Long var1, String var2, String var3, String var4);

    void saveMemberLogByName(String var1, String var2, Map<String, String> var3, String var4);

    void saveSysWarn(String var1, String var2, RoleTag var3);

    void saveSysWarn(Class var1, Serializable var2, String var3, String var4, RoleTag var5);

    void saveSysTemplateWarn(String var1, String var2, Map var3, RoleTag var4);

    void saveSysTemplateWarn(Class var1, Serializable var2, String var3, String var4, Map var5, RoleTag var6);

    void addApiLog(Map<String, String> var1, long var2);

    void incrementCallCount(String var1);

    void decrementCallCount(String var1);

    Map<String, Integer> getCallCountInfo();

    int getCallCount(String var1);

    void addSysLog(SysLogType var1, Map<String, String> var2);

    void addCountRecord(String var1, Long var2, Map var3);

    String logException(MonitorService.EXCEPTION_TAG var1, String var2, String var3, Throwable var4, Map<String, String> var5);

    void logViolation(String var1, String var2, Map<String, String> var3);

    void addTableData(String var1, Map<String, String> var2, byte[] var3);

    void addBeanData(Class var1, Map<String, String> var2);

    void addMonitorEvent(String var1, Map<String, String> var2);

    void addAccessLog(Map<String, String> var1);

    public static enum EXCEPTION_TAG {
        PAGE,
        SERVICE,
        JOB;

        private EXCEPTION_TAG() {
        }
    }
}
