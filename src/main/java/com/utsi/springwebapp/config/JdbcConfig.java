package com.utsi.springwebapp.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
public class JdbcConfig {
	
	@Bean(name="dataSource1")
	public DataSource dataSource1() {
		DriverManagerDataSource postgresqlDatasource = new DriverManagerDataSource();
		postgresqlDatasource.setDriverClassName("org.postgresql.Driver");
		postgresqlDatasource.setUrl("jdbc:postgresql://localhost/school");
		postgresqlDatasource.setPassword("mysecretpassword");
		postgresqlDatasource.setUsername("postgres");
		return postgresqlDatasource;
		
	}
	@Bean(name="dataSource2")
	public DataSource dataSource2() {
		DriverManagerDataSource postgresqlDatasource = new DriverManagerDataSource();
		postgresqlDatasource.setDriverClassName("org.postgresql.Driver");
		postgresqlDatasource.setUrl("jdbc:postgresql://localhost/student");
		postgresqlDatasource.setPassword("mysecretpassword");
		postgresqlDatasource.setUsername("postgres");
		return postgresqlDatasource;
		
	}
	 @Bean(name="postgresqJDBC1")
	    public JdbcTemplate jdbcTemplate1(DataSource dataSource1) { // dataSource1 variable must match with the bean name
	        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource1);
	        jdbcTemplate.setResultsMapCaseInsensitive(true);
	        return jdbcTemplate;
	    }
	 
	 @Bean(name="postgresqJDBC2")
	    public JdbcTemplate jdbcTemplate2(DataSource dataSource2) { // dataSource2 variable must match with the bean name
	        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource2);
	        jdbcTemplate.setResultsMapCaseInsensitive(true);
	        return jdbcTemplate;
	    }
	 
//	 Configuring multiple datasource
	 
//	   @Bean(name = "h2DataSource")
//	    public DataSource h2DataSource()
//	    {
//	        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
//	        dataSourceBuilder.driverClassName("org.h2.Driver");
//	        dataSourceBuilder.url("jdbc:h2:file:C:/temp/test");
//	        dataSourceBuilder.username("sa");
//	        dataSourceBuilder.password("");
//	        return dataSourceBuilder.build();
//	    }
//
//	    @Bean(name = "mySqlDataSource")
//	    @Primary
//	    public DataSource mySqlDataSource()
//	    {
//	        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
//	        dataSourceBuilder.url("jdbc:mysql://localhost/testdb");
//	        dataSourceBuilder.username("dbuser");
//	        dataSourceBuilder.password("dbpass");
//	        return dataSourceBuilder.build();
//	    }
	 
//	 Autowire primary datasource
//	 @Autowired
//	 DataSource dataSource;
//	 Autowire NON-primary datasource
//	 @Autowired
//	 @Qualifier("h2DataSource")
//	 DataSource dataSource;
}
