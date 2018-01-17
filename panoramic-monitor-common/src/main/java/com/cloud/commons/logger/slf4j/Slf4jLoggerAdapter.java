package com.cloud.commons.logger.slf4j;

import com.cloud.commons.logger.Level;
import com.cloud.commons.logger.Logger;
import com.cloud.commons.logger.LoggerAdapter;

import java.io.File;

public class Slf4jLoggerAdapter implements LoggerAdapter {
    
	@Override
    public Logger getLogger(String key) {
		return new Slf4jLogger(org.slf4j.LoggerFactory.getLogger(key));
	}

    @Override
    public Logger getLogger(Class<?> key) {
        return new Slf4jLogger(org.slf4j.LoggerFactory.getLogger(key));
    }

    private Level level;
    
    private File file;

    @Override
    public void setLevel(Level level) {
        this.level = level;
    }

    @Override
    public Level getLevel() {
        return level;
    }

    @Override
    public File getFile() {
        return file;
    }

    @Override
    public void setFile(File file) {
        this.file = file;
    }

}
