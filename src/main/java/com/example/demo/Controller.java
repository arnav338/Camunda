package com.example.demo;

import org.camunda.bpm.engine.ProcessEngine;
import org.camunda.bpm.engine.ProcessEngines;
import org.camunda.bpm.engine.RuntimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class Controller {
	
	@Autowired
	private RuntimeService runtimeService;
	
	@GetMapping("/start")
	public void processPostDeploy() {
		System.out.println("1");
		
		ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
	    RuntimeService runtimeService=processEngine.getRuntimeService();
		
		runtimeService.createProcessInstanceByKey("loanApproval").execute();
		//runtimeService.createProcessInstanceByKey("Process_1").execute();
	}
	
}
