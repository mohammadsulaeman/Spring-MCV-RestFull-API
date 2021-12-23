package com.restfull.service;

import com.restfull.bean.Employee;
import java.util.List;
public interface EmployeeService {
 public List<Employee> getEmployees();
 public Employee getEmployee(int employeeId);
 public int deleteEmployee(int employeeId); 
 public int updateEmployee(Employee employee);
 public int createEmployee(Employee employee); 
}