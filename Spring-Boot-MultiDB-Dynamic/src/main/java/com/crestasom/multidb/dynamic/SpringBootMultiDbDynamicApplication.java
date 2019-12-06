package com.crestasom.multidb.dynamic;

import java.sql.SQLException;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@SpringBootApplication
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "bookEntityManagerFactory", basePackages = {
		"com.crestasom.multidb.dynamic.model" }, transactionManagerRef = "bookTransactionManager")
@PropertySources({ @PropertySource("classpath:datasource-cfg.properties") })
public class SpringBootMultiDbDynamicApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootMultiDbDynamicApplication.class, args);
	}

	// Stores all the properties loaded by the @PropertySource
	@Autowired
	private Environment env;

	// Returns Routing DataSource (MyRoutingDataSource)
	@Autowired
	@Bean(name = "dataSource")
	public DataSource getDataSource(DataSource dataSource1, DataSource dataSource2) {

		System.out.println("## Create DataSource from dataSource1 & dataSource2");

		MyRoutingDataSource dataSource = new MyRoutingDataSource();

		dataSource.initDataSources(dataSource1, dataSource2);

		return dataSource;
	}

	@Bean(name = "dataSource1")
	public DataSource getDataSource1() throws SQLException {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();

		// See: datasouce-cfg.properties
		dataSource.setDriverClassName(env.getProperty("spring.datasource.driver-class-name.1"));
		dataSource.setUrl(env.getProperty("spring.datasource.url.1"));
		dataSource.setUsername(env.getProperty("spring.datasource.username.1"));
		dataSource.setPassword(env.getProperty("spring.datasource.password.1"));

		System.out.println("## DataSource1: " + dataSource);
		return dataSource;
	}

	@Bean(name = "dataSource2")
	public DataSource getDataSource2() throws SQLException {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();

		// See: datasouce-cfg.properties
		dataSource.setDriverClassName(env.getProperty("spring.datasource.driver-class-name.2"));
		dataSource.setUrl(env.getProperty("spring.datasource.url.2"));
		dataSource.setUsername(env.getProperty("spring.datasource.username.2"));
		dataSource.setPassword(env.getProperty("spring.datasource.password.2"));

		System.out.println("## DataSource2: " + dataSource);

		return dataSource;
	}

	@Bean(name = "entityManager")
	public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean(EntityManagerFactoryBuilder builder,
			@Qualifier("dataSource1") DataSource dataSource1, @Qualifier("dataSource2") DataSource dataSource2) {
		LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
		em.setDataSource(getDataSource(dataSource1, dataSource2));

		// em.setPackagesToScan(new String[] {"com.mm.domain.customer"});

		JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		em.setJpaVendorAdapter(vendorAdapter);

		em.setPackagesToScan("com.crestasom.multidb.dynamic.model");
		// em.setPersistenceUnitName("book");

		return em;
	}

	/*
	 * @Autowired
	 * 
	 * @Bean(name = "transactionManager") public DataSourceTransactionManager
	 * getTransactionManager(DataSource dataSource) { DataSourceTransactionManager
	 * txManager = new DataSourceTransactionManager();
	 * 
	 * txManager.setDataSource(dataSource);
	 * 
	 * return txManager; }
	 */

	@Autowired
	@Bean("transactionManager")
	public PlatformTransactionManager transactionManager(
			@Qualifier("entityManager") EntityManagerFactory entityManagerFactory) {
		return new JpaTransactionManager(entityManagerFactory);

	}

}
