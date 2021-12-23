package com.restfull.dao;

import java.util.List;

import com.restfull.bean.Employee;
 
public interface EmployeeDao {
 public List<Employee> getEmployees();
 public Employee getEmployee(int employeeId);
 public int deleteEmployee(int employeeId); 
 public int updateEmployee(Employee employee);
 public int createEmployee(Employee employee);
}