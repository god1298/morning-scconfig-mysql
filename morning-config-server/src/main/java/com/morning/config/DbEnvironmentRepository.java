package com.morning.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.config.environment.Environment;
import org.springframework.cloud.config.environment.PropertySource;
import org.springframework.cloud.config.server.environment.EnvironmentRepository;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import java.util.*;

/**
 * @author terryhuang
 * @date 2018/07/12
 */
@Configuration
@Profile("dbenv")
public class DbEnvironmentRepository implements EnvironmentRepository {

    @Value("${spring.cloud.config.server.default-label:master}")
    private String DEFAULT_LABEL;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Environment findOne(String application, String profile, String label) {
        if (StringUtils.isEmpty(application) || StringUtils.isEmpty(profile)) {
            return null;
        }
        if (StringUtils.isEmpty(label)) {
            label = "master";
        }
        List<Map<String, Object>> configList = jdbcTemplate.queryForList("SELECT CONFIG_KEY configKey, CONFIG_VALUE configValue FROM MN_CONFIG_INFO WHERE APP_NAME=? AND CONFIG_PROFILE=? and CONFIG_LABEL=?", application, profile, label);
        if(!CollectionUtils.isEmpty(configList)){
            Environment environment = new Environment(application,
                    StringUtils.commaDelimitedListToStringArray(profile),label,"version", "state");
            Map map = new HashMap<>();
            for(Map<String, Object> configMap:configList){
                map.put(configMap.get("configKey"), configMap.get("configValue"));
            }
            environment.add(new PropertySource(application + "_" + profile + "_" + label, map));
            return environment;
        }
        return new Environment(application,StringUtils.commaDelimitedListToStringArray(profile));
    }
}
