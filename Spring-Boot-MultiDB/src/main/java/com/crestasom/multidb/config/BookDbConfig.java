package com.crestasom.multidb.config;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "bookEntityManagerFactory", basePackages = {
		"com.crestasom.multidb.book.repo" }, transactionManagerRef = "bookTransactionManager")
public class BookDbConfig {

	@Bean(name = "bookDataSource")
	@ConfigurationProperties(prefix = "spring.book.datasource")
	public DataSource productDataSource() {
		return DataSourceBuilder.create().build();
	}

	@Bean(name = "bookEntityManagerFactory")
	public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean(EntityManagerFactoryBuilder builder,
			@Qualifier("bookDataSource") DataSource dataSource) {
		LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
		em.setDataSource(productDataSource());
		// em.setPackagesToScan(new String[] {"com.mm.domain.customer"});

		JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		em.setJpaVendorAdapter(vendorAdapter);
		em.setJpaProperties(additionalJpaProperties());
		em.setPackagesToScan("com.crestasom.multidb.book.model");
		// em.setPersistenceUnitName("book");

		return em;
	}

	@Bean("bookTransactionManager")
	public PlatformTransactionManager transactionManager(
			@Qualifier("bookEntityManagerFactory") EntityManagerFactory entityManagerFactory) {
		return new JpaTransactionManager(entityManagerFactory);

	}

	Properties additionalJpaProperties() {
		Properties properties = new Properties();
		properties.setProperty("hibernate.hbm2ddl.auto", "update");
		properties.setProperty("hibernate.dialect", "org.hibernate.dialect.SQLServer2012Dialect");
		properties.setProperty("hibernate.show_sql", "true");

		return properties;
	}

}
