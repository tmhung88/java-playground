package net.tmhung.example.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class StartUpListener implements ApplicationListener<ContextRefreshedEvent> {
  private static final Logger logger = LoggerFactory.getLogger(StartUpListener.class);
  @Override
  public void onApplicationEvent(ContextRefreshedEvent contextStartedEvent) {
    logger.warn("On Startup do something ....");
  }

}