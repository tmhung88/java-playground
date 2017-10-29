package net.tmhung.example.repository;

import net.tmhung.example.domain.Department;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DepartmentMapper implements ResultSetMapper<Department> {
  @Override
  public Department map(int index, ResultSet resultSet, StatementContext ctx) throws SQLException {
    return new Department(resultSet.getInt("id"), resultSet.getString("name"), resultSet.getString("location"));
  }
}
