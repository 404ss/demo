package com.example.demo;

import com.baomidou.mybatisplus.extension.spring.MybatisSqlSessionFactoryBean;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import javax.sql.DataSource;

@Configuration
public class MyBatisPlusConfig {
    @Bean
    public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
        MybatisSqlSessionFactoryBean factoryBean = new MybatisSqlSessionFactoryBean();
        factoryBean.setDataSource(dataSource);
        return factoryBean.getObject();
    }

    @Bean
    public MapperScannerConfigurer mapperScannerConfigurer() {
        MapperScannerConfigurer scannerConfigurer = new MapperScannerConfigurer();
        // 假设你的 UserMapper 在 com.example.demo 包下
        scannerConfigurer.setBasePackage("com.example.demo");
        // 必须加上下面这行，限制只扫描带 @Mapper 注解的接口
        scannerConfigurer.setAnnotationClass(org.apache.ibatis.annotations.Mapper.class);
        return scannerConfigurer;
    }
}