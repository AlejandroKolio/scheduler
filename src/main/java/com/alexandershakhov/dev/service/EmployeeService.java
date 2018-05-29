package com.alexandershakhov.dev.service;

import com.alexandershakhov.dev.entity.Employee;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author alexander.shakhov on 28.05.2018 13:34
 * @project spring-basics
 * @description
 */
public interface EmployeeService {

	List<Employee> getAllEmployees();

	void saveEmployee(Employee customer);

	Employee getEmployee(Long id);

	void deleteEmployee(Long id);

}
