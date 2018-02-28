package com.zonzie.demo.config.readWriteConfig;

import com.zonzie.demo.common.DataSourceType;

/**
 * 本地线程全局变量
 * Created by zonzie on 2018/2/26.
 */
public class DataSourceContextHolder {

    private static final ThreadLocal<String> LOCAL = new ThreadLocal<String>();

    public static ThreadLocal<String> getLocal() {
        return LOCAL;
    }

    /**
     * 读可能是多个库
     */
    static void read() {

        LOCAL.set(DataSourceType.read.getType());
    }

    /**
     * 写只有一个库
     */
    static void write() {
        LOCAL.set(DataSourceType.write.getType());
    }

    static String getJdbcType() {
        return LOCAL.get();
    }
}
