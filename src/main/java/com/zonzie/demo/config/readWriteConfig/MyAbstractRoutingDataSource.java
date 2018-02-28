package com.zonzie.demo.config.readWriteConfig;

import com.zonzie.demo.common.DataSourceType;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 多数据源切换
 * Created by zonzie on 2018/2/26.
 */
public class MyAbstractRoutingDataSource extends AbstractRoutingDataSource {
    private final int dataSourceNumber;
    private AtomicInteger count = new AtomicInteger(0);

    MyAbstractRoutingDataSource(int dataSourceNumber) {
        this.dataSourceNumber = dataSourceNumber;
    }

    @Override
    protected Object determineCurrentLookupKey() {
        String typeKey = DataSourceContextHolder.getJdbcType();
        if (typeKey.equals(DataSourceType.write.getType()))
            return DataSourceType.write.getType();
        // 读 简单负载均衡
        int number = count.getAndAdd(1);
        int i = number % dataSourceNumber;
        System.out.println("----------lookupKey------------"+typeKey+":"+i);
        return i;
    }
}
