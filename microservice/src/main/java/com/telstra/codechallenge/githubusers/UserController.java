package com.telstra.codechallenge.githubusers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

	UserService service;

	
	public UserController(UserService service) {
		this.service = service;
	}


	@GetMapping("/users")
	public List<ResponseUser> getZeroFollowerUser(@RequestParam(value = "numOfUsersToReturn", defaultValue="3") int numOfUsersToReturn){
		return service.getZeroFollowerUser(numOfUsersToReturn);
	}
}
