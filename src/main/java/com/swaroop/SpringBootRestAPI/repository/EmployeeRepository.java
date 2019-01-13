package com.swaroop.SpringBootRestAPI.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.swaroop.SpringBootRestAPI.model.Employee;

@Repository
public interface EmployeeRepository  extends CrudRepository<Employee,Long>{
   public List<Employee> getByFirstName(@Param("firstName") String firstName);
}
