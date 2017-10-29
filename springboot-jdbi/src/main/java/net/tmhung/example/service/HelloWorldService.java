package net.tmhung.example.service;

import net.tmhung.example.domain.Department;
import net.tmhung.example.repository.DepartmentRepository;
import net.tmhung.example.repository.DepartmentRowMapper;
import org.skife.jdbi.v2.DBI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class HelloWorldService implements CommandLineRunner {
  private static final Logger logger = LoggerFactory.getLogger(HelloWorldService.class);

  @Autowired
  private DBI dbi;

  @Autowired
  private NamedParameterJdbcTemplate jdbcTemplate;

  @Autowired
  private DepartmentRowMapper rowMapper;

  @Transactional
  public List<Department> getAllDepartmentsWithJdbcTemplate() {
    return jdbcTemplate.query("select * from department", rowMapper);
  }

  @Transactional
  public List<Department> getAllDepartments() {
    DepartmentRepository departmentRepository = dbi.onDemand(DepartmentRepository.class);
    return departmentRepository.getAllDepartments();
  }

  @Override
  public void run(String... args) throws Exception {
    getAllDepartments().forEach(department -> logger.info(department.toString()));
  }
}
