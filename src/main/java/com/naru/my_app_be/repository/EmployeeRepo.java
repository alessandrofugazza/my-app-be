package com.naru.my_app_be.repository;

import com.naru.my_app_be.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository is an interface that provides access to data in a database
 */
public interface EmployeeRepo extends JpaRepository<Employee, Integer> {
}

