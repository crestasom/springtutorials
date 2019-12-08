package com.crestasom.multidb.dynamica1.config;

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
@EnableJpaRepositories(entityManagerFactoryRef = "sutra2EntityManagerFactory", basePackages = {
		"com.crestasom.multidb.dynamica1.sutra2.repo" }, transactionManagerRef = "sutra2TransactionManager")
public class Sutra2DbConfig {

	@Bean(name = "sutra2DataSource")
	@ConfigurationProperties(prefix = "spring.sutra2.datasource")
	public DataSource productDataSource() {
		return DataSourceBuilder.create().build();
	}

	@Bean(name = "sutra2EntityManagerFactory")
	public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean(EntityManagerFactoryBuilder builder,
			@Qualifier("sutra2DataSource") DataSource dataSource) {
		LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
		em.setDataSource(productDataSource());
		// em.setPackagesToScan(new String[] {"com.mm.domain.customer"});

		JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		em.setJpaVendorAdapter(vendorAdapter);
		em.setJpaProperties(additionalJpaProperties());
		em.setPackagesToScan("com.crestasom.multidb.dynamica1.sutra2.model");
		// em.setPersistenceUnitName("book");

		return em;
	}

	@Bean("sutra2TransactionManager")
	public PlatformTransactionManager transactionManager(
			@Qualifier("sutra2EntityManagerFactory") EntityManagerFactory entityManagerFactory) {
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
