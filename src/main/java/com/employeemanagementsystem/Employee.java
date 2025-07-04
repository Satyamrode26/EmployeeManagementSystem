package com.employeemanagementsystem;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.ToString;
@Data
@ToString
@Entity
public class Employee {
	@Id
	private int id;
	private double salary;
	private String name;
	private String dept;
	
}
