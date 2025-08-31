package org.springframeworkcore.jdbc.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.init.DataSourceInitializer;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
public class DatabaseConfig {
	@Bean
    public DataSourceInitializer dataSourceInitializer(DataSource dataSource) {
        ResourceDatabasePopulator populator = new ResourceDatabasePopulator();
        populator.addScript(new ClassPathResource("schema.sql"));
        //populator.addScript(new ClassPathResource("data.sql"));

        DataSourceInitializer initializer = new DataSourceInitializer();
        initializer.setDataSource(dataSource);
        initializer.setDatabasePopulator(populator);
        return initializer;
    }
	
	@Bean
	DataSource dataSource() {
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
        ds.setUrl("jdbc:mysql://localhost:3306/spring_framework_core?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC");
        ds.setUsername("root");
        String dbPassword = System.getenv("MYSQL_DB_PASSWORD");
        if (dbPassword == null) {
            throw new IllegalStateException("Environment variable MYSQL_DB_PASSWORD is not set");
        }
        ds.setPassword(dbPassword);
        return ds;
		
	}
	
	@Bean
	JdbcTemplate jdbcTemplate(@Autowired DataSource dataSource) {
		return new JdbcTemplate(dataSource);
		
	}
	
	 @Bean
	 public PlatformTransactionManager transactionManager(DataSource dataSource) {
	    return new DataSourceTransactionManager(dataSource);
	 }
}
