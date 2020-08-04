package com.telstra.codechallenge.githubrepo;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RepoService {

	@Value("${repositories.base.url:https://api.github.com/search/repositories}")
	private String repoBaseUrl;
	
	private RestTemplate restTemplate;

	public RepoService(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}
	
	public List<ResponseRepo> getLatestRepository(int numOfRepoToReturn) {
		List<ResponseRepo> listRepo = new ArrayList<>();
		
		LocalDate currentDate = LocalDate.now();
		LocalDate lastWeek = currentDate.minus(1, ChronoUnit.WEEKS);
		String remUrl = "?q=created:" + lastWeek + "&sort=stars&order=desc";
		
		Repository templateObj = restTemplate.getForObject(repoBaseUrl + remUrl, Repository.class);
		
		if(templateObj != null && numOfRepoToReturn != 0) {
			List<Item> items = templateObj.getItems();
			for(int i=0; i<numOfRepoToReturn ; i++) {
				ResponseRepo responseRepo = new ResponseRepo();
				responseRepo.setHtml_url(items.get(i).getHtml_url());
				responseRepo.setWatchers_count(items.get(i).getWatchers_count());
				responseRepo.setLanguage(items.get(i).getLanguage());
				responseRepo.setDescription(items.get(i).getDescription());
				responseRepo.setName(items.get(i).getName());
				
				listRepo.add(responseRepo);
			}
		}
		return listRepo;
	}
}
