package com.pat.springboot.SpringBootMysqlExample.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pat.springboot.SpringBootMysqlExample.entity.User;
import com.pat.springboot.SpringBootMysqlExample.repository.UserRepository;

@Controller
@RequestMapping(path = "/demo")
@CrossOrigin(origins = "*")
public class MainController {
	@Autowired
	private UserRepository userRepository;

	@PostMapping(path = "/add")
	public @ResponseBody String addNewUser(@RequestBody User user) {

		userRepository.save(user);
		return "saved";
	}

	@GetMapping(path = "/all")
	public @ResponseBody Iterable<User> getAllUsers() {
		return userRepository.findAll();
	}

	@GetMapping(path = "/findUser/{email}")
	public List<User> findUser(@PathVariable String email) {
		return userRepository.findByEmail(email);
	}

}
