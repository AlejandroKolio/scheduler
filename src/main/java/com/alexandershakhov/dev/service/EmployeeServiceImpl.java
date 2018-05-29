package com.alexandershakhov.dev.service;

import com.alexandershakhov.dev.dao.EmployeeDAO;
import com.alexandershakhov.dev.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author alexander.shakhov on 28.05.2018 13:34
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDAO employeeDAO;

	@Override
	@Transactional
	public List<Employee> getAllEmployees() {
		return employeeDAO.getAllEmployees();
	}

	@Override
	@Transactional
	public void saveEmployee(Employee customer) {
		employeeDAO.saveEmployee(customer);
	}

	@Override
	@Transactional
	public Employee getEmployee(Long id) {
		return employeeDAO.getEmployee(id);
	}

	@Override
	@Transactional
	public void deleteEmployee(Long id) {
		employeeDAO.deleteEmployee(id);
	}
}
