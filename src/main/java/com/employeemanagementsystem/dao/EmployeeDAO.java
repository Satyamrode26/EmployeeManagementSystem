package com.employeemanagementsystem.dao;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.employeemanagementsystem.entity.Employee;
import com.employeemanagementsystem.repository.EmployeeJPARepository;

@Repository
public class EmployeeDAO {
	@Autowired
	EmployeeJPARepository ejpa;
	
	public String saveEmployee( Employee e) {
		Employee emp = ejpa.save(e);
		if(emp!=null) {
			return e.getName()+" Save successfully";
		}
		else return null+"";
		
		
	}
	
	public List<Employee> getAllEmployee(){
		return ejpa.findAll().stream().sorted((e1,e2)->e1.getName().compareTo(e2.getName())).collect(Collectors.toList());
	}
	

	public String  deleteById( int id) {
		 ejpa.deleteById(id);
		return "Employee deleted successfully";
	}

	public  String  findById( int id) {
		Optional<Employee> e = ejpa.findById(id);
		if(e!=null) {
			return e.get()+"";
		}
		else return null+"";
		
		
	}
	
//	@GetMapping("/apikey")
//	public String getapikey() {
//		return apikey;	
//	}
	

	public  List<Employee>  findByName( String name) {
		List<Employee> e = ejpa.findByName(name);
		return e;
	}

	public  List<Employee>  findByDept(String dept) {
		List<Employee> e = ejpa.findByDept(dept);
		return e;
	}
	
	public  Optional<Employee>  findByIdAndDept( int id,String dept) {
	 return ejpa.findByIdAndDept(id,dept);	
	}
	
	public List<Employee> getDetailsGreaterThanSalary( double Salary){
		return ejpa.getDetailsGreaterThanSalary(Salary);
	}

	public List<Employee> getDetailGreaterThanSalary(  double Salary){
		return ejpa.getDetailGreaterThanSalary(Salary);
	}
 

}
