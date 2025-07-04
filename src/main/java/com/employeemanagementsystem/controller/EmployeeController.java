package com.employeemanagementsystem.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.employeemanagementsystem.Employee;
import com.employeemanagementsystem.dao.EmployeeDAO;

@RestController
public class EmployeeController {
	@Autowired
	EmployeeDAO dao;
	@Value("${app.apikey}")
	String apikey;
	@PostMapping("/add")
	public String saveEmployee(@RequestBody Employee e) {
		return  dao.saveEmployee(e);
	}
	@GetMapping("/findall")
	public List<Employee> getAllEmployee(){
		return dao.getAllEmployee().stream().sorted((e1,e2)->e1.getName().compareTo(e2.getName())).collect(Collectors.toList());
	}
	@DeleteMapping("/delete")
	public String     deleteById(@RequestParam int id) {
		 dao.deleteById(id);
		return "Employee deleted successfully";
	}
	@GetMapping("/findbyid")
	public  String  findById(@RequestParam int id) {
	return dao.findById(id);
	}
	
	@GetMapping("/apikey")
	public String getapikey() {
		return apikey;	
	}
	
	@GetMapping("/findbyName")
	public  List<Employee>  findByName(@RequestParam String name) {
		List<Employee> e = dao.findByName(name);
		return e;
	}
	@GetMapping("/findbyDept")
	public  List<Employee>  findByDept(@RequestParam String dept) {
		List<Employee> e = dao.findByDept(dept);
		return e;
	}
	@GetMapping("/findbyIdAndDept")
	public  Optional<Employee>  findByIdAndDept(@RequestParam int id,@RequestParam String dept) {
	 return dao.findByIdAndDept(id,dept);	
	}
	@GetMapping("/find-more-than-salary")
	public List<Employee> getDetailsGreaterThanSalary( @RequestParam double Salary){
		return dao.getDetailsGreaterThanSalary(Salary);
	}
	@GetMapping("/find-more-than-salarys")
	public List<Employee> getDetailGreaterThanSalary( @RequestParam double Salary){
		return dao.getDetailGreaterThanSalary(Salary);
	}
 
	
}
