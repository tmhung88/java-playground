package net.tmhung.example.repository;

import net.tmhung.example.domain.Department;
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.customizers.Mapper;

import java.util.List;

public interface DepartmentRepository {
  @SqlQuery("select * from department")
  @Mapper(DepartmentMapper.class)
  List<Department> getAllDepartments();

  void close();
}
