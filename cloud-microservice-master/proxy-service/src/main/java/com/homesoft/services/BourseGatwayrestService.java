package com.homesoft.services;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.hateoas.Resources;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class BourseGatwayrestService {
	
	@Autowired
	@Qualifier("proxyRestTemplate")
    @LoadBalanced
    private RestTemplate loadBalanced;
	
	@RequestMapping(value="/names")
	public Collection<Societe> getSocietes(@RequestParam(value="page", defaultValue="0")int page,@RequestParam(value="size", defaultValue="7") int size){
		ParameterizedTypeReference<Resources<Societe>> parameterizedTypeReference = new ParameterizedTypeReference<Resources<Societe>>() {
		};
		
		
		return loadBalanced.exchange("http://societe-service/societes?page="+page+"&size="+size, HttpMethod.GET, null, parameterizedTypeReference).getBody().getContent();
		
	}
	
	
	

}

class Societe{
	private Long id;
	private String nomSociete;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNomSociete() {
		return nomSociete;
	}
	public void setNomSociete(String nomSociete) {
		this.nomSociete = nomSociete;
	}
	
	
}