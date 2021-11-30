package com.employees.crudspringboot.dao;

import java.util.List;

import com.employees.crudspringboot.entity.Employee;

public interface EmployeeDAO 
{
	public List<Employee> getEmployees();
	
	public void deleteEmployee(int id);
	
	public void saveEmployee(Employee employee);

	public Employee getEmployee(int id);
}
