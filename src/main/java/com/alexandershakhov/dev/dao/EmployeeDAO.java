package com.alexandershakhov.dev.dao;

import com.alexandershakhov.dev.entity.Employee;

import java.util.List;

/**
 * @author alexander.shakhov on 29.05.2018 17:19
 * @project scheduler
 * @description
 */
public interface EmployeeDAO {

	List<Employee> getAllEmployees();

	void saveEmployee(Employee customer);

	Employee getEmployee(Long id);

	void deleteEmployee(Long id);

}
