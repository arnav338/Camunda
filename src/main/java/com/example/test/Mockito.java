package com.example.test;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.camunda.bpm.engine.test.Deployment;
import org.camunda.bpm.engine.test.mock.Mocks;
import org.junit.Test;
import org.junit.runner.RunWith;
//import org.powermock.api.mockito.PowerMockito;  
//import org.powermock.core.classloader.annotations.PrepareForTest;  
//import org.powermock.modules.junit4.PowerMockRunner;

//@RunWith(PowerMockRunner.class)
public class Mockito {
	
	
	
	@Test
	@Deployment(resources = "loanApproval.bpmn")
	public void testPath() throws Exception {
		
		TestClass t = new TestClass();
		Mocks.register("TestClass", t); 
		
		
		Mocks.register("execute", new JavaDelegate() {
			public void execute(DelegateExecution execution) throws Exception {}
		});
		
		
	}
	
	
	
	
}
