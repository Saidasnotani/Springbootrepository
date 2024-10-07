package com.example.demo.Service;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.Model.Employee;

import com.example.demo.Repository.EmpRepository;

@Service
public class EmpService {

	@Autowired
	private EmpRepository repository = null;

	
	public EmpService(EmpRepository repository) {
		super();
		this.repository = repository;
		EmpRepository.setFactory();
	}
	
	public List<Employee> getEmployeeList() {
	//	logger.info("getting all employees >> ");
		return repository.getAll();
	}
	
	public Employee findEmployeebyId(int Empid) {
		
		return repository.findEmployeebyId(Empid);
	}
	
	public void deleteEmpbyId(int Id)
	{
			repository.deleteEmployeebyId(Id);
	}
	
	public void saveEmployee(Employee emloyee)
	{
			repository.saveEmployee(emloyee);
	}
	
}
