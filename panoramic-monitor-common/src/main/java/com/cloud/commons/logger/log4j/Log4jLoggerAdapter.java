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
package com.cloud.commons.logger.log4j;

import com.cloud.commons.logger.Level;
import com.cloud.commons.logger.Logger;
import com.cloud.commons.logger.LoggerAdapter;
import org.apache.log4j.Appender;
import org.apache.log4j.FileAppender;
import org.apache.log4j.LogManager;

import java.io.File;
import java.util.Enumeration;

public class Log4jLoggerAdapter implements LoggerAdapter {

    private File            file;

	@SuppressWarnings("unchecked")
	public Log4jLoggerAdapter() {
		try {
			org.apache.log4j.Logger logger = LogManager.getRootLogger();
            if (logger != null) {
                Enumeration<Appender> appenders = logger.getAllAppenders();
                if (appenders != null) {
                    while (appenders.hasMoreElements()) {
                        Appender appender = appenders.nextElement();
                        if (appender instanceof FileAppender) {
                            FileAppender fileAppender = (FileAppender)appender;
                            //TODO String filename = fileAppender.getFile();
                            String filename = fileAppender.toString();
                            file = new File(filename);
                            break;
                        }
                    }
                }
            }
        } catch (Throwable t) {
        }
	}

	@Override
    public Logger getLogger(Class<?> key) {
		return new Log4jLogger(LogManager.getLogger(key));
	}

	@Override
    public Logger getLogger(String key) {
		return new Log4jLogger(LogManager.getLogger(key));
	}

	@Override
    public void setLevel(Level level) {
		LogManager.getRootLogger().setLevel(toLog4jLevel(level));
	}

	@Override
    public Level getLevel() {
		return fromLog4jLevel(LogManager.getRootLogger().getLevel());
	}

	@Override
    public File getFile() {
		return file;
	}

	private static org.apache.log4j.Level toLog4jLevel(Level level) {
		if (level == Level.ALL) {
            return org.apache.log4j.Level.ALL;
        }
		if (level == Level.TRACE) {
            return org.apache.log4j.Level.TRACE;
        }
		if (level == Level.DEBUG) {
            return org.apache.log4j.Level.DEBUG;
        }
		if (level == Level.INFO) {
            return org.apache.log4j.Level.INFO;
        }
		if (level == Level.WARN) {
            return org.apache.log4j.Level.WARN;
        }
		if (level == Level.ERROR) {
            return org.apache.log4j.Level.ERROR;
        }
		// if (level == Level.OFF)
			return org.apache.log4j.Level.OFF;
	}

	private static Level fromLog4jLevel(org.apache.log4j.Level level) {
		if (level == org.apache.log4j.Level.ALL) {
            return Level.ALL;
        }
		if (level == org.apache.log4j.Level.TRACE) {
            return Level.TRACE;
        }
		if (level == org.apache.log4j.Level.DEBUG) {
            return Level.DEBUG;
        }
		if (level == org.apache.log4j.Level.INFO) {
            return Level.INFO;
        }
		if (level == org.apache.log4j.Level.WARN) {
            return Level.WARN;
        }
		if (level == org.apache.log4j.Level.ERROR) {
            return Level.ERROR;
        }
		// if (level == org.apache.log4j.Level.OFF)
			return Level.OFF;
	}

    @Override
    public void setFile(File file) {
        
    }

}
