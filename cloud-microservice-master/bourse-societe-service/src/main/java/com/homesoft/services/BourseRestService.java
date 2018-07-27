package com.homesoft.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope(proxyMode=ScopedProxyMode.NO)
@RestController
public class BourseRestService {
	@Value("${me}")
	private String me;
	
	@RequestMapping(value ="/messages", method= RequestMethod.GET)
	private String getMe(){
		System.out.println("---------------------");
		System.out.println("is me"+me);
		System.out.println("---------------------");
		return me;
	}

}
