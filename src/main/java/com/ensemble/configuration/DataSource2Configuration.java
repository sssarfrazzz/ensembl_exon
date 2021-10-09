package com.ensemble.configuration;

import javax.sql.DataSource;

import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

import com.zaxxer.hikari.HikariDataSource;
/**
 * Configure data source 2.Data source can be MySQl,Oracle and similar RDBMS vendors
 * @author sarfraz
 *
 */
@Configuration
@EnableJpaRepositories(basePackages = "com.ensemble.db.repository2", entityManagerFactoryRef = "datasource2MemberFactory")
public class DataSource2Configuration {

	@Bean
	@ConfigurationProperties("db2.datasource")
	public DataSourceProperties dataSource2Properties() {
		return new DataSourceProperties();
	}

	@Bean
	@ConfigurationProperties("db2.datasource.configuration")
	public DataSource dataSource2() {
		return dataSource2Properties().initializeDataSourceBuilder().type(HikariDataSource.class).build();
	}

	@Bean(name = "datasource2MemberFactory")
	public LocalContainerEntityManagerFactoryBean dataSource1MemberFactory(EntityManagerFactoryBuilder builder) {
		return builder.dataSource(dataSource2()).packages("com.ensemble.db.entity").build();
	}
}
