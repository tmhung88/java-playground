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
@PropertySource("classpath:hikari.properties")
@ConfigurationProperties(prefix = "datasource")
public class JdbiConfig extends HikariConfig {
  @Bean
  DataSource dataSource() {

    HikariConfig jdbcConfig = new HikariConfig();
    jdbcConfig.setJdbcUrl("jdbc:h2:mem:test;DB_CLOSE_DELAY=-1;INIT=runscript from 'classpath:/db.sql'");
    return new HikariDataSource(jdbcConfig);
  }

  @Bean
  DBI dbi(DataSource dataSource) {
     return new DBI(dataSource);
  }

}
