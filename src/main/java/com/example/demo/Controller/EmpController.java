package com.example.demo.Controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.example.demo.Model.Employee;
import com.example.demo.Service.EmpService;


//@RestController
@Controller
@RequestMapping("/EmpInfo")
public class EmpController{
	
	@Autowired
	private EmpService employeeService = null;
	
	@RequestMapping("/getempinfo")
	public ModelAndView getallEmployees() {
		System.out.println("inside get all employees");
		List<Employee> list = employeeService.getEmployeeList();
		System.out.println("list size"+list.size());
		/*
		 * Employee e;
		 * 
		 * for(int i=0;i<list.size();i++) { e= (Employee)list.get(i);
		 * System.out.println("list["+i+"]"+e.getEmp_name()); }
		 */
		//model.addAttribute("list", list); 
		ModelAndView mv = new ModelAndView();
		mv.setViewName("displayEmployees");
		mv.addObject("list", list);
		return mv;		
	//	String s = "Welcome to your first Controller";
	//	return s;
	}
	
	@RequestMapping("/addnewEmpl")
	public ModelAndView addnewEmpl(Model model)
	{
		Employee EmpForm = new Employee();
		ModelAndView mv = new ModelAndView();
		model.addAttribute("EmpForm", EmpForm);
		mv.setViewName("addEmployee");
		mv.addObject("model",model );
		return mv;
	}
	
	@PostMapping("/saveEmpl")
	public ModelAndView addemployee(@ModelAttribute("EmpForm") Employee employee)
	{
		System.out.println("in addemployee user name"+employee.getEmp_name());
		employeeService.saveEmployee(employee);
		List<Employee> list = employeeService.getEmployeeList();
		System.out.println("list size"+list.size());
		ModelAndView mv = new ModelAndView();
		mv.setViewName("displayEmployees");
		mv.addObject("list", list);
		return mv;
	}
	@PostMapping("/delEmpl")
	public ModelAndView deleteemployee(@RequestParam int empid)
	{
		System.out.println("in deleteemployee empid "+empid);
		employeeService.deleteEmpbyId(empid);
		List<Employee> list = employeeService.getEmployeeList();
		System.out.println("list size"+list.size());
		ModelAndView mv = new ModelAndView();
		mv.setViewName("displayEmployees");
		mv.addObject("list", list);
		return mv;
	}
	
}