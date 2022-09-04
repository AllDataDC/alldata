package com.alibaba.tesla.authproxy.config.database;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;

/**
 * @author cdx
 * @date 2019/10/10
 */
@Configuration
@MapperScan(basePackages = {"com.alibaba.tesla.authproxy.model.teslamapper"}, sqlSessionFactoryRef = "teslaSessionFactory")
public class TeslaDbConfig {

    @Autowired
    @Qualifier("teslaDataSource")
    private DataSource teslaDataSource;
    @Value("${mybatis.config}")
    private String mybatisConfig;

    @Bean("teslaSessionFactory")
    public SqlSessionFactory teslaSessionFactory() throws Exception {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(teslaDataSource);
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        factoryBean.setConfigLocation(resolver.getResource(mybatisConfig));
        return factoryBean.getObject();
    }

    @Bean("teslaSessionTemplate")
    public SqlSessionTemplate teslaSessionTemplate(
        @Qualifier("teslaSessionFactory") SqlSessionFactory teslaSessionFactory) {
        SqlSessionTemplate template = new SqlSessionTemplate(teslaSessionFactory);
        return template;
    }
}
