package com.omega.platform.core.base;

import com.omega.platform.core.constant.SpringCloudConstant;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

/**
*@Description 当前系统环境变量
*@Author Allen.Lv
*@Date 3/24/2020
*@Time 12:36 AM
*/
@Service
@Slf4j
public class OmegaEnvironment implements EnvironmentAware {
    private Environment environment;
    private String applicationName;

    @PostConstruct
    public void postConstruct() {
        this.applicationName = this.environment.getProperty(SpringCloudConstant.APPLICATION_NAME);

        if (log.isInfoEnabled()) {
            log.info("application name is {}.", this.applicationName);
        }
    }

    public String getApplicationName() {
        return this.applicationName;
    }

    public String getProperty(String key) {
        return this.environment.getProperty(key);
    }

    public <T> T getProperty(String key, Class<T> targetType) {
        return this.environment.getProperty(key, targetType);
    }

    @Override
    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }
}
