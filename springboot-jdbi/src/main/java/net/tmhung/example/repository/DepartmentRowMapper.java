package net.tmhung.example.repository;

import net.tmhung.example.domain.Department;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class DepartmentRowMapper implements RowMapper<Department> {
  @Override
  public Department mapRow(ResultSet resultSet, int i) throws SQLException {
    return new Department(resultSet.getInt("id"), resultSet.getString("name"), resultSet.getString("location"));
  }
}
