package com.example.demo.Restcalls;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;

import com.example.demo.Model.Employee;
import com.example.demo.Service.EmpService;

@RestController
@RequestMapping("/Empdetails")
public class Employeerestcontroller {
	@Autowired
	private EmpService employeeService = null;
	
	@GetMapping("/getallempinfo")
	@ResponseBody
	public List<Employee> getallEmployees() {
		System.out.println("inside get all employees");
		List<Employee> list = employeeService.getEmployeeList();
		System.out.println("list size"+list.size());
	    return list;
	}
	
	
	
	
	@GetMapping("/getEmp/{id}")
	public Employee getEmployee(@PathVariable Integer id) {
		return employeeService.findEmployeebyId(id);
	}
	
	@PostMapping("/saveEmpl")
	@ResponseBody
	public Employee addemployee(@RequestBody Employee employee)
	{
		System.out.println("in addemployee user name"+employee.getEmp_name());
		employeeService.saveEmployee(employee);
		return employee;
	}
	@DeleteMapping("/delEmpl/{id}")
	public void deleteemployee(@PathVariable int id)
	{
		System.out.println("in deleteemployee empid "+id);
		employeeService.deleteEmpbyId(id);
	
	}
	
	
	
	

}
