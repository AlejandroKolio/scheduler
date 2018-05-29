package com.alexandershakhov.dev.controller;

import com.alexandershakhov.dev.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author alexander.shakhov on 29.05.2018 17:45
 * @project scheduler
 * @description
 */
@Controller
@RequestMapping("/api")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@GetMapping("/employees")
	public String getEmployees(Model model) {
		model.addAttribute("employees", employeeService.getAllEmployees());

		return "employees";
	}
}
