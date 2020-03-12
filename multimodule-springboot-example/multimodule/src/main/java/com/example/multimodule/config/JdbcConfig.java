package com.example.multimodule.config;

import java.beans.PropertyVetoException;
import javax.sql.DataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * @author ehurtado
 *
 */
@Configuration
@PropertySources({@PropertySource("classpath:properties/db.properties")})
@ComponentScan("com.co.openintl.tec.gcs.*")
public class JdbcConfig {

  private final static Logger log = LoggerFactory.getLogger(JdbcConfig.class);

  /**
   * Set para datasource usado en jdbc template
   * 
   * @param env
   * @return : objeto DataSource que contiene la configuracion del pool de conexiones
   */
  @Bean(destroyMethod = "close")
  DataSource dataSource(Environment env) {
    ComboPooledDataSource dataSource = new ComboPooledDataSource();

    try {
      dataSource.setDriverClass(env.getRequiredProperty("jdbc.driverClassName"));
    } catch (IllegalStateException | PropertyVetoException e) {
      log.error("dataSource: " + e.getMessage());
      e.printStackTrace();
    }

    dataSource.setJdbcUrl(env.getRequiredProperty("jdbc.url"));
    dataSource.setUser(env.getRequiredProperty("jdbc.username"));
    dataSource.setPassword(env.getRequiredProperty("jdbc.password"));
    dataSource
        .setAcquireIncrement(env.getRequiredProperty("c3p0.acquire_increment", Integer.class));
    dataSource.setMinPoolSize(env.getRequiredProperty("c3p0.min_size", Integer.class));
    dataSource.setMaxPoolSize(env.getRequiredProperty("c3p0.max_size", Integer.class));
    dataSource.setMaxIdleTime(env.getRequiredProperty("c3p0.max_idle_time", Integer.class));
    dataSource.setUnreturnedConnectionTimeout(
        env.getRequiredProperty("c3p0.unreturned_connection_timeout", Integer.class));

    return dataSource;
  }

  /**
   * Bean(spring) que permite settear la propiedad JdbcTemplate en los acceso a datos
   * 
   * @param dataSource : conexion a la base de datos
   * @return : nueva instancia del objeto JdbcTemplate
   */
  @Bean
  JdbcTemplate jdbcTemplate(DataSource dataSource) {
    return new JdbcTemplate(dataSource);
  }

  /**
   * Bean(spring) que permite settear la propiedad DataSourceTransactionManager en los acceso a
   * datos para transacciones en el acceso a base de datos
   * 
   * @param dataSource : conexion a la base de datos
   * @return : nueva instancia del objeto DataSourceTransactionManager
   */
  @Bean
  DataSourceTransactionManager dataSourceTransactionManager(DataSource dataSource) {
    return new DataSourceTransactionManager(dataSource);
  }

  /**
   * Cargar propiedades a spring
   * 
   * @return
   */
  @Bean
  public PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
    return new PropertySourcesPlaceholderConfigurer();
  }

}
