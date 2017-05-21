package com.zain.config;

import org.apache.derby.jdbc.EmbeddedDataSource;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * Created by qhasan on 8/25/2016.
 */
@Configuration
@EnableTransactionManagement
@ComponentScan(basePackages = "com.zain.dao")
public class PersistenceConfig {

    private static Logger LOG = LoggerFactory.getLogger(PersistenceConfig.class);
    @Bean
    public DataSource dataSource(){
        LOG.info("Configuring the data source");
        EmbeddedDataSource ds = new EmbeddedDataSource();
        ds.setDatabaseName("jdbcDemoDB");
        ds.setCreateDatabase("create");
        return ds;
    }

    @Bean
    public Properties hibernateProperties(){
        LOG.info("Configuring the properties");
        Properties hibernateProperties = new Properties();
        hibernateProperties.setProperty("hibernate.dialect", "org.hibernate.dialect.DerbyDialect");
        hibernateProperties.setProperty("hibernate.show_sql", "true");
        hibernateProperties.setProperty("hibernate.hbm2ddl.auto", "update");
        hibernateProperties.setProperty("hibernate.generate_statistics", "true");
        hibernateProperties.setProperty("hibernate.session.events.log", "true");
        return hibernateProperties;
    }

    @Bean
    public LocalSessionFactoryBean sessionFactory(){
        LOG.info("Configuring the session factory");
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(dataSource());
        sessionFactory.setPackagesToScan(
                new String[] {"com.zain.model"}
        );
        sessionFactory.setHibernateProperties(hibernateProperties());
        return sessionFactory;
    }

    @Bean
    @Autowired
    public HibernateTransactionManager hibernateTransactionManager(SessionFactory sessionFactory){
        HibernateTransactionManager hibernateTransactionManager =  new HibernateTransactionManager();
        hibernateTransactionManager.setSessionFactory(sessionFactory);
        return hibernateTransactionManager;
    }

}
