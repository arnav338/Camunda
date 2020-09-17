package com.example.demo;

//import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.apache.ibatis.logging.LogFactory;
import org.camunda.bpm.engine.runtime.ProcessInstance;
import org.camunda.bpm.engine.test.ProcessEngineRule;
import org.camunda.bpm.extension.process_test_coverage.junit.rules.TestCoverageProcessEngineRuleBuilder;
import org.camunda.bpm.engine.test.Deployment;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.camunda.bpm.engine.test.assertions.ProcessEngineTests.*;
//import static org.camunda.bpm.engine.test.assertions.bpmn.AbstractAssertions.init;
import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@ContextConfiguration
public class DemoApplicationTests {

	@ClassRule
	@Rule
	public static ProcessEngineRule rule = TestCoverageProcessEngineRuleBuilder.create().build();

	/*
	static {
		LogFactory.useSlf4jLogging(); // MyBatis
	}
	*/
	
	@Before
	public void setup() {
		init(rule.getProcessEngine());
	}

	@Test
	@Deployment(resources = "process.bpmn")
	public void testParsingAndDeployment() {
		// nothing is done here, as we just want to check for exceptions during
		// deployment
	}

	@Test
	@Deployment(resources = "loanApproval.bpmn")
	public void testHappyPath() {
		ProcessInstance processInstance = runtimeService().startProcessInstanceByKey("loanApproval");

		assertThat(processInstance).isWaitingAt("Task_0dfv74n").task().hasName("Loan Approval");
		// complete(task());
		// assertThat(processInstance).isWaitingAt("UserTask2Task").task().hasName("user
		// task 2");
		// complete(task(), withVariables("prc_ok", true));
		// assertThat(processInstance).isEnded();
	}

}
