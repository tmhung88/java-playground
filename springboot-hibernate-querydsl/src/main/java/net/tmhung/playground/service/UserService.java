package net.tmhung.playground.service;

import net.tmhung.playground.domain.User;
import net.tmhung.playground.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class UserService {
  @Autowired
  private UserRepository userRepository;

  public User getUser(long id) {

    return new User();
  }

  public User saveUser() {
    User user = new User();
    user.setBirthday(LocalDate.of(2000, 1, 1).atStartOfDay());
    user.setLastOnline(ZonedDateTime.now());
    user.setName("Hung Tran");
    return userRepository.save(user);
  }

  public List<User> listUsers() {
    return new ArrayList<>();
  }
}
