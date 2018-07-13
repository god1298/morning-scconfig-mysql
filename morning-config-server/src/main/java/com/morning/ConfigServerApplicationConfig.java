/*
 * Copyright 2016 Zhongan.com All right reserved. This software is the
 * confidential and proprietary information of Zhongan.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Zhongan.com.
 */
package com.morning;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

// TODO: Auto-generated Javadoc

/**
 * 全局配置-  在配置中心中配置，可切换各种环境.
 */
@Configuration

/**
 * Instantiates a new fcp cs application config.
 */
@Data
@Service
public class ConfigServerApplicationConfig {
    
    /**  应用名. */
    @Value("${spring.application.name}")
    public String appName;

}
