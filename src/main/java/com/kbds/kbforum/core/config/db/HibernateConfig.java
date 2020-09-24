package com.kbds.kbforum.core.config.db;

import java.util.Properties;
import javax.sql.DataSource;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * <pre>
 * 파일명     : HibernateConfig.java
 * 프로젝트  : OJTForum
 * 날짜        : 2020. 9. 17.
 * ===============================================================================
 * 			날짜	      		|    	작성자		 	|			내	용		      |	  
 * ===============================================================================
 * 	     2020. 9. 17.     	|	       유한솔                	|   DB 및 hibernate설정 클래스       |	
 * ===============================================================================
 * </pre>
 */

@Configuration
@PropertySource("classpath:db.properties")
@EnableTransactionManagement(proxyTargetClass = true)
@EnableJpaRepositories(basePackages = {"com.kbds.kbforum.*"})
@ComponentScan(basePackages = "com.kbds.kbforum.core")
public class HibernateConfig {

  @Autowired
  private Environment env;

  @Bean // DB config
  public DataSource getDataSource() {

    BasicDataSource dataSource = new BasicDataSource();

    dataSource.setDriverClassName(env.getProperty("db.driver"));

    dataSource.setUrl(env.getProperty("db.url"));

    dataSource.setUsername(env.getProperty("db.username"));

    dataSource.setPassword(env.getProperty("db.password"));

    return dataSource;

  }

  @Bean
  public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {

    return new PersistenceExceptionTranslationPostProcessor();

  }

  @Bean
  public LocalContainerEntityManagerFactoryBean entityManagerFactory() {

    LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();

    em.setDataSource(getDataSource());

    em.setPackagesToScan(new String[] {"com.kbds.kbforum"});

    JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();

    em.setJpaVendorAdapter(vendorAdapter);

    // em.setSharedCacheMode(SharedCacheMode.ENABLE_SELECTIVE);

    Properties props = new Properties();

    props.put("hibernate.show_sql", env.getProperty("hibernate.show_sql"));

    props.put("hibernate.physical_naming_strategy",
        env.getProperty("hibernate.physical_naming_strategy"));

    props.put("hibernate.dialect", env.getProperty("hibernate.dialect"));

    em.setJpaProperties(props);

    return em;

  }

  @Bean
  public PlatformTransactionManager transactionManager() {

    JpaTransactionManager transactionManager = new JpaTransactionManager();

    transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());

    return transactionManager;

  }

}
