package com.alexandershakhov.dev.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.util.Properties;
import java.util.logging.Logger;

/**
 * @author alexander.shakhov on 29.05.2018 14:52
 * @project scheduler
 * @description Main Application Configuration class.
 */

@EnableWebMvc
@Configuration
@EnableTransactionManagement
@ComponentScan("com.alexandershakhov.dev")
@PropertySource({"classpath:mysql.properties"})
public class ApplicationConfiguration {

	private Logger logger = Logger.getLogger(getClass().getName());

	@Autowired
	private Environment env;

	@Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/views/");
		viewResolver.setSuffix(".jsp");

		return viewResolver;
	}

	@Bean
	public DataSource dataSource() {
		ComboPooledDataSource db = new ComboPooledDataSource();

		try {
			db.setDriverClass(env.getProperty("jdbc.driver"));
		} catch (PropertyVetoException exc) {
			exc.printStackTrace();
			throw new RuntimeException(exc);
		}
		logger.info("JDBC URL: \t"  + env.getProperty("jdbc.url"));
		logger.info("JDBC USER:\t" + env.getProperty("jdbc.user"));

		db.setJdbcUrl(env.getProperty("jdbc.url"));
		db.setUser(env.getProperty("jdbc.user"));
		db.setPassword(env.getProperty("jdbc.password"));

		db.setInitialPoolSize(getIntProperty(env.getProperty("connection.pool.initialPoolSize")));
		db.setMinPoolSize(getIntProperty(env.getProperty("connection.pool.minPoolSize")));
		db.setMaxPoolSize(getIntProperty(env.getProperty("connection.pool.maxPoolSize")));
		db.setMaxIdleTime(getIntProperty(env.getProperty("connection.pool.maxIdleTime")));

		return db;
	}

	private Properties getHibernateProperties() {
		Properties p = new Properties();

		p.setProperty("hibernate.dialect", 		  env.getProperty("hibernate.dialect"));
		p.setProperty("hibernate.show_sql", 	  env.getProperty("hibernate.show_sql"));
		p.setProperty("hibernate.packagesToScan", env.getProperty("hibernate.packagesToScan"));

		return p;
	}

	@Bean
	public LocalSessionFactoryBean sessionFactory() {
		LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();

		sessionFactoryBean.setDataSource(dataSource());
		sessionFactoryBean.setPackagesToScan(env.getProperty("hibernate.packagesToScan"));
		sessionFactoryBean.setHibernateProperties(getHibernateProperties());

		return sessionFactoryBean;
	}

	@Bean
	@Autowired
	public HibernateTransactionManager transactionManager(SessionFactory sessionFactory) {

		// setup transaction manager based on session factory
		HibernateTransactionManager txManager = new HibernateTransactionManager();
		txManager.setSessionFactory(sessionFactory);

		return txManager;
	}

	private Integer getIntProperty(String name) {
		return Integer.parseInt(name);
	}
}
