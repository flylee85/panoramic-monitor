package com.monitor.service.scheduletask;

import java.util.List;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.cloud.util.DateUtil;
import com.monitor.api.exceptionrecord.PanoramicExceptionRecordService;
import com.monitor.model.exceptionrecord.PanoramicExceptionRecord;
/**
 * 
 * @author summer
 * 定时任务必须实现Job接口
 *
 */
@Component
public class Test implements Job{
	@Autowired
	@Qualifier("exceptionRecordService")
	private PanoramicExceptionRecordService exceptionRecordService;

	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		List<PanoramicExceptionRecord> list = exceptionRecordService.findAll();
		list.forEach(  record ->{
			System.out.println(DateUtil.currentTimeStr());
		});
		System.out.println("哈哈，执行了定时任务"+list);
		
	}
	
}
