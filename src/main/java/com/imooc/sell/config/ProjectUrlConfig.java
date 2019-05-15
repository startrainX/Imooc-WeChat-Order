package com.imooc.sell.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author ：zsp
 * @date ：Created in 2019/5/15 17:07
 */
@Component
@Data
@ConfigurationProperties(prefix = "projectUrl")
public class ProjectUrlConfig {

    public String sell;
}
