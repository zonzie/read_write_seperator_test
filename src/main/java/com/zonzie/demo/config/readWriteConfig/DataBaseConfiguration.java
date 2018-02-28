package com.zonzie.demo.config.readWriteConfig;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

/**
 * 数据库配置:解析properties文件
 * Created by zonzie on 2018/2/26.
 */
@Configuration
public class DataBaseConfiguration {

    @Value("${spring.datasource.type}")
    private Class<? extends DataSource> dataSourceType;

    @Bean(name = "writeDataSource", destroyMethod = "close", initMethod = "init")
    @Primary
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource writeDataSource() {
        System.out.println("-----------------write-------------------");
        return DataSourceBuilder.create().type(dataSourceType).build();
    }

    @Bean(name = "readDataSource1", destroyMethod = "close", initMethod = "init")
    @ConfigurationProperties(prefix = "spring.read1")
    public DataSource read1DataSource() {
        System.out.println("------------------read1---------------------");
        return DataSourceBuilder.create().type(dataSourceType).build();
    }

    @Bean(name = "readDataSource2", destroyMethod = "close", initMethod = "init")
    @ConfigurationProperties(prefix = "spring.read2")
    public DataSource read2DataSource() {
        System.out.println("------------------read2---------------------");
        return DataSourceBuilder.create().type(dataSourceType).build();
    }

    @Bean("readDataSources")
    public List<DataSource> readDataSources(){
        List<DataSource> dataSources=new ArrayList<>();
        dataSources.add(read1DataSource());
        dataSources.add(read2DataSource());
        return dataSources;
    }
}
