package net.tmhung.example.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@EnableAutoConfiguration(exclude = {
  DataSourceAutoConfiguration.class
})
public class SpringBootConfig {
}
