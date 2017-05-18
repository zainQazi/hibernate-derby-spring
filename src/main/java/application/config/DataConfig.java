package application.config;

import org.apache.derby.jdbc.EmbeddedDataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * Created by qhasan on 8/25/2016.
 */
@Configuration
public class DataConfig {

    @Bean
    public DataSource dataSource(){
        EmbeddedDataSource ds = new EmbeddedDataSource();
        ds.setDatabaseName("jdbcDemoDB");
        ds.setCreateDatabase("create");
        return ds;
    }

    @Bean
    public SessionFactory sessionFactory(){
        
    }

}
