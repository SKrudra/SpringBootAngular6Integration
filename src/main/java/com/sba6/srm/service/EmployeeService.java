package com.sba6.srm.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sba6.srm.entity.Employee;
import com.sba6.srm.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	public Employee getEmployee(Long id) {
		Employee employee = null;
		Optional<Employee> opt = employeeRepository.findById(id);
		if (opt.isPresent()) {
			employee = opt.get();
			Employee manager;
			if (employee.getMgrId() != null) {
				manager = employeeRepository.findById(employee.getMgrId()).get();
				employee.setManagerName(manager.getFirstName() + " " + manager.getLastName());
			}
		}
		return employee;
	}
	
	public String getManagerName(Employee employee) {
		if(employee.getMgrId() != null) {
			Employee manager = employeeRepository.findById(employee.getMgrId()).get();
			return manager.getFirstName() + " " + manager.getLastName();
		} else return null;
	}
	
	public Employee getEmployee(String email) {
		Optional<Employee> opt = employeeRepository.findByEmail(email);
		if(opt.isPresent()) {
			return opt.get();
		} else {
			return null;
		}
	}

}
