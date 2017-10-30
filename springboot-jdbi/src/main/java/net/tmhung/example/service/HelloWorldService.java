package net.tmhung.example.service;

import net.tmhung.example.domain.Department;
import net.tmhung.example.repository.DepartmentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class HelloWorldService implements CommandLineRunner {
  private static final Logger logger = LoggerFactory.getLogger(HelloWorldService.class);

  @Autowired
  private DepartmentRepository departmentRepository;

  @Transactional
  public List<Department> getAllDepartments() {
    return departmentRepository.getAllDepartments();
  }

  @Override
  public void run(String... args) throws Exception {
    getAllDepartments().forEach(department -> logger.info(department.toString()));
  }
}
