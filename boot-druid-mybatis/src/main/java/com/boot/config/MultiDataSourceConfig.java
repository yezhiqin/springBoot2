package com.boot.config;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

/**
 * 多数据源配置读取
 * Created by yezhiqin on 2018/6/29.
 */
@Configuration
public class MultiDataSourceConfig {
    @Primary
    @Bean(name = "oneDataSource")
    @ConfigurationProperties("spring.datasource.druid.one")
    public DataSource dataSourceOne(){
        return DruidDataSourceBuilder.create().build();
    }
    @Bean(name = "twoDataSource")
    @ConfigurationProperties("spring.datasource.druid.two")
    public DataSource dataSourceTwo(){
        return DruidDataSourceBuilder.create().build();
    }
}
