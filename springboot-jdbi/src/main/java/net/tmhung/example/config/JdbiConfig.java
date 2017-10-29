package net.tmhung.example.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.skife.jdbi.v2.IDBI;
import org.skife.jdbi.v2.spring.DBIFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@EnableTransactionManagement
public class JdbiConfig extends HikariConfig {
  @Bean
  DataSource dataSource() {
    HikariConfig config = new HikariConfig();
    config.setJdbcUrl("jdbc:h2:mem:test;INIT=RUNSCRIPT FROM 'classpath:/db.sql'");
    config.setUsername("sa");
    config.setUsername("");

    return new HikariDataSource(config);
  }

  @Bean
   PlatformTransactionManager transactionManager() {
    return new DataSourceTransactionManager(dataSource());
  }

  @Bean
  DBIFactoryBean dbiFactoryBean(DataSource dataSource) {
    return new DBIFactoryBean(dataSource);
  }

  @Bean
  public IDBI idbi(DBIFactoryBean dbiFactoryBean) throws Exception {
    return dbiFactoryBean.getObject();
  }
}
