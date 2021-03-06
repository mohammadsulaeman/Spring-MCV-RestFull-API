package com.restfull.dao;

import java.util.List;

import javax.sql.DataSource;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
 
import com.restfull.bean.Employee;
 
@Repository("employeeDao")
public class EmployeeDaoImpl implements EmployeeDao {
 
 private JdbcTemplate jdbcTemplate;
 
 @Autowired
 public void setDataSource(DataSource dataSource) {
  this.jdbcTemplate = new JdbcTemplate(dataSource);
 }
 
 public List<Employee> getEmployees() {
  List<Employee> employees = null ;
  
  try {
   employees = jdbcTemplate.query("SELECT * FROM trn_employee",new BeanPropertyRowMapper<Employee>(Employee.class));   
  } catch (DataAccessException e) {
   e.printStackTrace();
  }
  return employees;
 }
 
 public Employee getEmployee(int employeeId) {
  Employee employee = null;
  try {
   employee = jdbcTemplate.queryForObject("SELECT * FROM trn_employee WHERE employeeId = ?",
     new Object[] { employeeId }, new BeanPropertyRowMapper<Employee>(Employee.class));
  } catch (DataAccessException e) {
   e.printStackTrace();
  }
  return employee;
 
 }
 
 public int deleteEmployee(int employeeId) {
  int count = jdbcTemplate.update("DELETE from trn_employee WHERE employeeId = ?", new Object[] { employeeId });
  return count;
 }
 
 public int updateEmployee(Employee employee) {
  int count = jdbcTemplate.update(
    "UPDATE trn_employee set firstName = ? , lastName = ? , age = ? where employeeId = ?", new Object[] {
      employee.getFirstName(), employee.getLastName(), employee.getAge(), employee.getEmployeeId() });
  return count;
 }
 
 public int createEmployee(Employee employee) {
  int count = jdbcTemplate.update(
    "INSERT INTO trn_employee(firstName, lastName, age)VALUES(?,?,?)", new Object[] {
       employee.getFirstName(), employee.getLastName(), employee.getAge() });
  return count;
 }
 
}
