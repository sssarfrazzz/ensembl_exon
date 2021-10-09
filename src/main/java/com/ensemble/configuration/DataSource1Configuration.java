package com.ensemble.configuration;

import javax.sql.DataSource;

import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

import com.zaxxer.hikari.HikariDataSource;
/**
 * Configure data source 1. Data source can be MySQl,Oracle and similar RDBMS vendors
 * @author sarfraz
 *
 */
@Configuration
@EnableJpaRepositories(basePackages = "com.ensemble.db.repository",entityManagerFactoryRef = "datasource1MemberFactory")
public class DataSource1Configuration {

	@Bean
	@Primary
	@ConfigurationProperties("db1.datasource")
	public DataSourceProperties dataSourceProperties() {
		return new DataSourceProperties();
	}
	
	@Bean
    @Primary
    @ConfigurationProperties("db1.datasource.configuration")
    public DataSource dataSource1() {
        return dataSourceProperties().initializeDataSourceBuilder()
                .type(HikariDataSource.class).build();
    }
	
	@Bean(name="datasource1MemberFactory")
	@Primary
	public LocalContainerEntityManagerFactoryBean dataSource1MemberFactory(EntityManagerFactoryBuilder builder) {
	 return builder.dataSource(dataSource1()).packages("com.ensemble.db.entity").build();
	}
}
