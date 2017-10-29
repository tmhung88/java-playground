package net.tmhung.example.repository;

import net.tmhung.example.domain.Department;
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.customizers.Mapper;

import java.util.List;

public interface DepartmentRepository {
  @SqlQuery("select name from department where department.id = :id")
  @Mapper(DepartmentMapper.class)
  Department findNameById(@Bind("id") int id);

  void close();
}
