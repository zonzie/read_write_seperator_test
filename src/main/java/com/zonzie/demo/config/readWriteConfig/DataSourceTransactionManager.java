package com.zonzie.demo.config.readWriteConfig;

import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.annotation.Resource;
import javax.sql.DataSource;

/**
 * Created by zonzie on 2018/2/26.
 */
@Configuration
@EnableTransactionManagement
public class DataSourceTransactionManager extends DataSourceTransactionManagerAutoConfiguration{
    /**
     * 自定义事务
     * MyBatis自动参与到spring事务管理中，无需额外配置，只要org.mybatis.spring.SqlSessionFactoryBean引用的数据源与DataSourceTransactionManager引用的数据源一致即可，否则事务管理会不起作用。
     * @return
     */
    @Resource(name = "writeDataSource")
    private DataSource dataSource;
    @Bean(name = "transactionManager")
    public org.springframework.jdbc.datasource.DataSourceTransactionManager transactionManagers() {
        System.out.println("-------------------- transactionManager init ---------------------");
        return new org.springframework.jdbc.datasource.DataSourceTransactionManager(dataSource);
    }
}
