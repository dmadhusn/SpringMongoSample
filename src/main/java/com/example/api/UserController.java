package com.example.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.api.entity.User;
import com.example.api.model.request.UserRequest;
import com.example.api.repository.UserRepository;

@RestController
public class UserController {
	
	@Autowired
	UserRepository userRepo;
	
	@PostMapping(path="/createuser")
	public ResponseEntity<String> createUser(@RequestBody UserRequest usrreq) {
		User usr=new User();
		usr.setName(usrreq.getName());
		usr.setEmail(usrreq.getEmail());
		userRepo.save(usr);
		return new ResponseEntity<String>("User is created", HttpStatus.OK);
		
	}
	
	@GetMapping(path="/getUsers")
	public Iterable<User> getUsers() {
		return userRepo.findAll();
		
	}

}
