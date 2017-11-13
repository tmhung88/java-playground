package net.tmhung.playground.web;

import net.tmhung.playground.domain.Greeting;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

  @RequestMapping
  public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
    return new Greeting(String.format("Hello %s", name));
  }

}
