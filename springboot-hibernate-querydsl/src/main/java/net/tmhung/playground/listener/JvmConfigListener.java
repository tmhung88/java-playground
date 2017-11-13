package net.tmhung.playground.listener;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.TimeZone;

@Component
public class JvmConfigListener implements ApplicationListener<ContextRefreshedEvent> {

  private static final TimeZone UTC = TimeZone.getTimeZone("UTC");

  @Override
  public void onApplicationEvent(ContextRefreshedEvent contextStartedEvent) {
    TimeZone.setDefault(UTC);
  }
}
