package net.tmhung.example;

import net.tmhung.example.config.JdbiConfig;
import net.tmhung.example.config.ServiceConfig;
import net.tmhung.example.config.SpringBootConfig;
import org.springframework.boot.Banner;
import org.springframework.boot.builder.SpringApplicationBuilder;


public class App {

  public static void main(String[] args) throws Exception {
    new SpringApplicationBuilder()
      .bannerMode(Banner.Mode.OFF)
      .sources(SpringBootConfig.class, JdbiConfig.class, ServiceConfig.class)
      .run(args);
  }
}
