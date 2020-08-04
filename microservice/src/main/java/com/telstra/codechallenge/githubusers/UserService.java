package com.telstra.codechallenge.githubusers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UserService {

	@Value("${user.base.url:https://api.github.com/search/users?q=followers:0&sort=joined&order=asc}")
	private String userBaseUrl;
	
	private RestTemplate restTemplate;
	
	public UserService(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	public List<ResponseUser> getZeroFollowerUser(int numOfUsersToReturn){
		List<ResponseUser> listUser = new ArrayList<>();
		
		User templateObj = restTemplate.getForObject(userBaseUrl, User.class);
		if(templateObj != null && numOfUsersToReturn !=0 ) {
			List<Item> items = templateObj.getItems();
			for(int i=0; i < numOfUsersToReturn; i++) {
				ResponseUser responseUser = new ResponseUser();
				responseUser.setId(items.get(i).getId());
				responseUser.setLogin(items.get(i).getLogin());
				responseUser.setHtml_url(items.get(i).getHtml_url());
				
				listUser.add(responseUser);
			}
		}
		return listUser;
	}

}
