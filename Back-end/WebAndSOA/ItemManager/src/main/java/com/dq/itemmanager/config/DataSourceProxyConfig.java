package com.dq.itemmanager.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import io.seata.rm.datasource.DataSourceProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.annotation.Resource;
import javax.sql.DataSource;

@Configuration
public class DataSourceProxyConfig {
    @Resource
    private DataSourceConfig dataSourceConfig;

    @Bean("dataSource")
    public DataSource druidDataSource() {
        DruidDataSource hikariDataSource = new DruidDataSource();
        hikariDataSource.setUsername(dataSourceConfig.getUsername());
        hikariDataSource.setPassword(dataSourceConfig.getPassword());
        hikariDataSource.setUrl(dataSourceConfig.getUrl());
        hikariDataSource.setDriverClassName(dataSourceConfig.getDriveClassName());
        return hikariDataSource;
    }

    /**
     * JDBC操作配置
     */
    @Bean(name = "dataOneTemplate")
    public JdbcTemplate jdbcTemplate (@Autowired DataSource dataSource){
        return new JdbcTemplate(dataSource) ;
    }

    /**
     * 配置 Druid 监控界面
     */
    @Bean
    public ServletRegistrationBean statViewServlet(){
        ServletRegistrationBean srb =
                new ServletRegistrationBean(new StatViewServlet(),"/druid/*");
        //设置控制台管理用户
        srb.addInitParameter("loginUsername","root");
        srb.addInitParameter("loginPassword","root");
        //是否可以重置数据
        srb.addInitParameter("resetEnable","false");
        return srb;
    }
    @Bean
    public FilterRegistrationBean statFilter(){
        //创建过滤器
        FilterRegistrationBean frb =
                new FilterRegistrationBean(new WebStatFilter());
        //设置过滤器过滤路径
        frb.addUrlPatterns("/*");
        //忽略过滤的形式
        frb.addInitParameter("exclusions",
                "*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*");
        return frb;
    }

    @Bean
    @Primary
    public DataSourceProxy dataSourceProxy(DataSource dataSource) {
        return new DataSourceProxy(dataSource);
    }
}

