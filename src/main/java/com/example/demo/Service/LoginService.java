package com.example.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.Repository.LoginRepository;

@Service
public class LoginService {

	
	@Autowired
	private LoginRepository repository = null;

	
	public LoginService(LoginRepository repository) {
		super();
		this.repository = repository;
		LoginRepository.setFactory();
	}
	
	public boolean checkLoginbyusername(String username)
	{
		return repository.checkLoginUserbyname(username);
	}
}
