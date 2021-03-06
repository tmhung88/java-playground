package net.tmhung.example.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import net.tmhung.example.spring.jdbi.EnableJdbiRepository;
import net.tmhung.example.spring.jdbi.JdbiRepositoryScanRegistrar;
import org.skife.jdbi.v2.IDBI;
import org.skife.jdbi.v2.spring.DBIFactoryBean;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@EnableTransactionManagement
@PropertySource("classpath:hikari.properties")
@EnableJdbiRepository("net.tmhung.example.repository")
public class JdbiConfig extends HikariConfig {
  public static final String JDBI_FACTORY_BEAN_NAME = "idbi";
  @Bean
  @ConfigurationProperties("datasource")
  public DataSource dataSource() {
    return DataSourceBuilder.create()
      .type(HikariDataSource.class).build();
  }


  @Bean
   PlatformTransactionManager transactionManager(DataSource dataSource) {
    return new DataSourceTransactionManager(dataSource);
  }

  @Bean
  DBIFactoryBean dbiFactoryBean(DataSource dataSource) {
    return new DBIFactoryBean(dataSource);
  }

  @Bean(JDBI_FACTORY_BEAN_NAME)
  public IDBI idbi(DBIFactoryBean dbiFactoryBean) throws Exception {
    return dbiFactoryBean.getObject();
  }


}
