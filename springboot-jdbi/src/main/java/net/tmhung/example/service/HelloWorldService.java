package net.tmhung.example.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

@Service
public class HelloWorldService implements CommandLineRunner {
  private static final Logger logger = LoggerFactory.getLogger(HelloWorldService.class);
  @Override
  public void run(String... args) throws Exception {
    logger.warn("Hello World!!");
  }
}
