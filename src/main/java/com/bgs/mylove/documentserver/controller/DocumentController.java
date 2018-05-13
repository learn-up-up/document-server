package com.bgs.mylove.documentserver.controller;
import com.bgs.mylove.documentserver.feign.UserServerFeign;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * <pre>
 * *********************************************
 * Copyright BAIBU.
 * All rights reserved.
 * Description: ${添加描述}
 * HISTORY:
 * *********************************************
 *  Version       Date      Author    Desc
 *   v1.0     2018-05-11      wujianwen  ${添加描述}
 *
 * *********************************************
 * </pre>
 */
@RestController
@RequestMapping("/document")
public class DocumentController {

	private final static Logger logger = LoggerFactory.getLogger(DocumentController.class);

	@Autowired
	private DiscoveryClient discoveryClient;

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private UserServerFeign userServerFeign;

	@GetMapping("/hello")
	public String getUser(){
		return this.restTemplate.getForObject("http://user-server/user/login",String.class);
	}

	@GetMapping("/feign/hello")
	public String getUserFeign(){
		return userServerFeign.login();
	}


	@GetMapping("/read/{tittle}")
	public String getDocument(@PathVariable("tittle") String tittle){
		List<ServiceInstance> serviceInstances = discoveryClient.getInstances("user-server");
		StringBuffer result = new StringBuffer();
		for (ServiceInstance instance : serviceInstances) {
			result.append(instance.getHost()).append(",");
		}
		return result.toString();
	}

}
