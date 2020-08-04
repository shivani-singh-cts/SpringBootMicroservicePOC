package com.telstra.codechallenge.githubrepo;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RepoController {

	RepoService service;

	public RepoController(RepoService service) {
		this.service = service;
	}

	@GetMapping("/repositories")
	public List<ResponseRepo> getLatestRepository(@RequestParam(value="numOfRepoToReturn", defaultValue="2") int numOfRepoToReturn) {
		return service.getLatestRepository(numOfRepoToReturn);
	}
}
