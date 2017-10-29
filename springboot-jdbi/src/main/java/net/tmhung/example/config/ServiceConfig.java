package net.tmhung.example.config;

import org.springframework.context.annotation.ComponentScan;


@ComponentScan(basePackages = {
  "net.tmhung.example.listener",
  "net.tmhung.example.service",
  "net.tmhung.example.repository",
})
public class ServiceConfig {
}
