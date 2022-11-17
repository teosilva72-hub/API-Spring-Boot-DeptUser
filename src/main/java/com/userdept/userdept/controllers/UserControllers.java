package com.userdept.userdept.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.userdept.userdept.entities.User;
import com.userdept.userdept.repositories.UserRepository;

@RestController
@RequestMapping(value = "/user")
public class UserControllers {

	@Autowired
	private UserRepository repository;
	
	@GetMapping
	public List<User> FindAll(){
		List<User> result = repository.findAll();
		return result;
	}
	
	@GetMapping(value = "/{id}")
	public User FindById(@PathVariable Long id){
		User result = repository.findById(id).get();
		return result;
	}
	
	@PostMapping
	public User Insert(@RequestBody User user){
		System.out.println("teste");
		User result = repository.save(user);
		return result;
	}
	
	@DeleteMapping(value = "/{id}")
	public String Delete(@PathVariable Long id) {
		String text = "";
		System.out.println(id);
		if(repository.existsById(id)) {
			repository.deleteById(id);
			text = "Usuário deletado com sucesso!";
		}else text = "Usuário não encontado!";
		return text;
	}
	
}
