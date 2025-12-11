package org.t2404e.test1112.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.t2404e.test1112.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
