package com.employeemanagementsystem.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.employeemanagementsystem.entity.Employee;



public interface EmployeeJPARepository extends JpaRepository<Employee, Integer>{
	public List<Employee> findByName(String name);
	public List<Employee> findByDept(String dept);
	public Optional<Employee> findByIdAndDept(int id,String dept);
	
	@Query(value = "select * from employee where salary>?1",nativeQuery = true)
	public List<Employee> getDetailsGreaterThanSalary( double Salary);
	
	@Query(value = "select e from Employee e where e.salary>?1")
	public List<Employee> getDetailGreaterThanSalary( double Salary);

}   
