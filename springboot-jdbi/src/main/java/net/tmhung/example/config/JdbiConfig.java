package net.tmhung.example.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.skife.jdbi.v2.DBI;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@EnableTransactionManagement
//@PropertySource("classpath:hikari.properties")
//@ConfigurationProperties()
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
  DBI dbi(DataSource dataSource) {
     return new DBI(dataSource);
  }
}
