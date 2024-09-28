package com.example.demo.Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.example.demo.Model.Login;
import com.example.demo.Service.LoginService;

@Controller
@RequestMapping("/")
public class LoginController {
	
	@Autowired
	private LoginService loginService = null;

	@RequestMapping("/")	
	public ModelAndView getFirstpage(Model model,HttpServletRequest request)
	{
		Login LoginForm = new Login();
		ModelAndView mv = new ModelAndView();
		model.addAttribute("LoginForm", LoginForm);
		String LoginError = new String("LoginError");
		request.setAttribute(LoginError," ");
		mv.setViewName("LoginUser");
		mv.addObject("model",model );
		return mv;
	}
	
	@RequestMapping("/loginError")	
	public ModelAndView getLoginpage(Model model,HttpServletRequest request,HttpServletResponse response )
	{
		Login LoginForm = new Login();
		ModelAndView mv = new ModelAndView();
		model.addAttribute("LoginForm", LoginForm);
		mv.setViewName("LoginUser");
		mv.addObject("model",model );
		String LoginError = new String("LoginError");
		request.setAttribute(LoginError,"Invalid username or password");
		return mv;
	}
	
	@PostMapping("/LoginUser")
	public void loginuser(@ModelAttribute("LoginForm") Login login,HttpServletResponse response)
	{
		System.out.println("in loginuser username"+login.getLogin_user());
        boolean loginuserexists=loginService.checkLoginbyusername(login.getLogin_user());
        if(loginuserexists)
        {
			try {
				response.sendRedirect("/demoEmpApp/EmpInfo/getempinfo");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
        else
        	try {
        	response.sendRedirect("/demoEmpApp/loginError");
        	}catch(IOException e) {        		
        	}
		//ModelAndView mv = new ModelAndView();	        	
	//	return mv;
	}

}
