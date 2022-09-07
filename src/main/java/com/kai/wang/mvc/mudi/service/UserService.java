package com.kai.wang.mvc.mudi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kai.wang.mvc.mudi.model.User;
import com.kai.wang.mvc.mudi.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository ur;
	
	public User buscarUsuario(String nome) {
		return (User) this.ur.findByName(nome);
	}

}
