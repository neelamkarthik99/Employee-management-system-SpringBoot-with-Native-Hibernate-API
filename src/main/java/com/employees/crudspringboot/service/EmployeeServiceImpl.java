package com.employees.crudspringboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.employees.crudspringboot.dao.EmployeeDAO;
import com.employees.crudspringboot.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService
{
	@Autowired
	private EmployeeDAO employeeDAO;

	@Override
	@Transactional
	public List<Employee> getEmployees() 
	{
		return employeeDAO.getEmployees();
	}

	@Override
	@Transactional
	public void deleteEmployee(int id) 
	{
		employeeDAO.deleteEmployee(id);
	}

	@Override
	@Transactional
	public void saveEmployee(Employee employee) 
	{
		employeeDAO.saveEmployee(employee);
	}

	@Override
	@Transactional
	public Employee getEmployee(int id) 
	{
		return employeeDAO.getEmployee(id);
	}

}
