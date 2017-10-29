package net.tmhung.example.config;

import org.springframework.context.annotation.ComponentScan;


@ComponentScan(basePackages = {
  "net.tmhung.example.listener",
  "net.tmhung.example.service",
})
public class ServiceConfig {
}
