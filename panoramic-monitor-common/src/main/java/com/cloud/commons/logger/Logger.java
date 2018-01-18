/*
 * Copyright 1999-2011 Alibaba Group.
 *  
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *  
 *      http://www.apache.org/licenses/LICENSE-2.0
 *  
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.cloud.commons.logger;

/**
 * 日志接口 <p/> 声明：引用自commons-logging
 *
 * @author william.liangf
 */
public interface Logger {

    /**
     * 输出跟踪信息
     *
     * @param msg 信息内容
     */
    void trace(String msg);

    /**
     * 输出跟踪信息
     *
     * @param e 异常信息
     */
    void trace(Throwable e);
    
    /**
     * 输出跟踪信息
     *
     * @param msg 信息内容
     * @param e 异常信息
     */
    void trace(String msg, Throwable e);

	/**
	 * 输出调试信息
	 *
	 * @param msg 信息内容
	 */
    void debug(String msg);

	/**
     * 输出调试信息
     *
     * @param e 异常信息
     */
    void debug(Throwable e);
	
	/**
	 * 输出调试信息
	 *
	 * @param msg 信息内容
	 * @param e 异常信息
	 */
    void debug(String msg, Throwable e);

	/**
	 * 输出普通信息
	 *
	 * @param msg 信息内容
	 */
    void info(String msg);

	/**
     * 输出普通信息
     *
     * @param e 异常信息
     */
    void info(Throwable e);
	
	/**
	 * 输出普通信息
	 *
	 * @param msg 信息内容
	 * @param e 异常信息
	 */
    void info(String msg, Throwable e);

	/**
	 * 输出警告信息
	 *
	 * @param msg 信息内容
	 */
    void warn(String msg);
	
	/**
     * 输出警告信息
     *
     * @param e 异常信息
     */
    void warn(Throwable e);

	/**
	 * 输出警告信息
	 *
	 * @param msg 信息内容
	 * @param e 异常信息
	 */
    void warn(String msg, Throwable e);

	/**
	 * 输出错误信息
	 *
	 * @param msg 信息内容
	 */
    void error(String msg);
	
	/**
     * 输出错误信息
     *
     * @param e 异常信息
     */
    void error(Throwable e);

	/**
	 * 输出错误信息
	 *
	 * @param msg 信息内容
	 * @param e 异常信息
	 */
    void error(String msg, Throwable e);

    /**
     * 跟踪信息是否开启
     *
     * @return 是否开启
     */
    boolean isTraceEnabled();

	/**
	 * 调试信息是否开启
	 *
	 * @return 是否开启
	 */
    boolean isDebugEnabled();

	/**
	 * 普通信息是否开启
	 *
	 * @return 是否开启
	 */
    boolean isInfoEnabled();

	/**
	 * 警告信息是否开启
	 *
	 * @return 是否开启
	 */
    boolean isWarnEnabled();
	
	/**
	 * 错误信息是否开启
	 *
	 * @return 是否开启
	 */
    boolean isErrorEnabled();

}