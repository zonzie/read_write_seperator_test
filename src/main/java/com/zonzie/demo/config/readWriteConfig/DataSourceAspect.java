package com.zonzie.demo.config.readWriteConfig;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * 拦截设置本地线程变量
 * Created by zonzie on 2018/2/26.
 */
@Aspect
@Component
public class DataSourceAspect {
    @Before("execution(* com.zonzie.demo.*.mapper..*.select*(..)) || execution(* com.zonzie.demo.*.mapper..*.find*(..))")
    public void setReadDataSourceType() {
        System.out.println("------------------readAspect------------------");
        DataSourceContextHolder.read();
    }

    @Before("execution(* com.zonzie.demo.*.mapper..*.insert*(..)) || execution(* com.zonzie.demo.*.mapper..*.update*(..))")
    public void setWriteDataSourceType() {
        System.out.println("------------------writeAspect------------------");
        DataSourceContextHolder.write();
    }
}
