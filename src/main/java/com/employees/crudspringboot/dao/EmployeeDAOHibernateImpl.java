package com.employees.crudspringboot.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.employees.crudspringboot.entity.Employee;

@Repository
public class EmployeeDAOHibernateImpl implements EmployeeDAO
{
	
	private EntityManager entityManager;
	
	@Autowired
	public EmployeeDAOHibernateImpl(EntityManager theentityManager)
	{
		entityManager = theentityManager;
	}

	@Override
	public List<Employee> getEmployees() 
	{
		Session currentsession = entityManager.unwrap(Session.class);
		
		Query<Employee> thequery = currentsession.createQuery("from Employee", Employee.class);
		
		List<Employee> employees = thequery.getResultList();
		
		return employees;
	}

	@Override
	public void deleteEmployee(int id) 
	{
		Session currentsession = entityManager.unwrap(Session.class);
		
		Employee employee = currentsession.get(Employee.class, id);
		
		currentsession.delete(employee);
	}

	@Override
	public void saveEmployee(Employee employee) 
	{
		Session currentsession = entityManager.unwrap(Session.class);
		
		currentsession.saveOrUpdate(employee);
	}

	@Override
	public Employee getEmployee(int id) 
	{
		Session currentsession = entityManager.unwrap(Session.class);
		
		Employee employee = currentsession.get(Employee.class,id);
		
		return employee;
	}

}
