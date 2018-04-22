package com.yangmiemie.ele.config;

import com.yangmiemie.ele.common.persistence.interceptor.PaginationInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Yang.
 * Email : vincent1094259423@yahoo.com
 * Date  : 2018-04-22 17:24
 * Description:
 */
@Configuration
public class MybatisPlusConfig {

    /**
     * mybatis分页插件
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        PaginationInterceptor paginationInterceptor =  new PaginationInterceptor();
        paginationInterceptor.initProperties(null);
        return paginationInterceptor;
    }
}
