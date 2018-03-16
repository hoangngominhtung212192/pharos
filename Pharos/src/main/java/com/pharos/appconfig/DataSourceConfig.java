package com.pharos.appconfig;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

@Configuration
@EnableJpaRepositories(basePackages = { 
		"com.pharos.repository" }
,entityManagerFactoryRef = "pharosEntityManagerFactory",transactionManagerRef = "pharosTransactionManager")
public class DataSourceConfig {
	
	/**
     * Create JpaTransactionManager for pharos.
     * 
     * @return JpaTransactionManager for pharos.
     * @throws SQLException
     *             SQLException
     */
    @Bean(name = "pharosTransactionManager")
    public JpaTransactionManager pharosTransactionManager() throws SQLException{
        return new JpaTransactionManager(pharosEntityManagerFactory().getObject());
    }
	
	/**
     * Create data source instance for pharos.
     * 
     * @return data source instance for pharos
     * @throws SQLException
     *             SQLException
     */
    @Bean(name = "pharosEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean pharosEntityManagerFactory() throws SQLException {
        // TODO Auto-generated method stub
        HibernateJpaVendorAdapter jpaVendorAdapter = new HibernateJpaVendorAdapter();
        jpaVendorAdapter.setGenerateDdl(false);
        LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
        factoryBean.setPersistenceUnitName("pharosPersistenceUnit");
        factoryBean.setDataSource(pharosDataSource());
        factoryBean.setJpaVendorAdapter(jpaVendorAdapter);
        factoryBean.setPackagesToScan("com.pharos.*");
        return factoryBean;
    }
	
	/**
     * Create data source instance for pharos
     * @return data source instance for pharos
     * @throws SQLException
     *           SQLException 
     * 
     */
    @Primary
    @Bean(name = "pharosDataSource")
    @ConfigurationProperties(prefix = "spring.datasource")
    DataSource pharosDataSource(){
        return DataSourceBuilder.create().build();
    }
}
