package a.springboot.circleci.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import a.springboot.circleci.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
