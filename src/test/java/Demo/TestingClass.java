package Demo;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import com.example.demo.DemoApplication;
import org.apache.ibatis.logging.LogFactory;
import org.camunda.bpm.engine.ProcessEngine;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.impl.cfg.StandaloneInMemProcessEngineConfiguration;
import org.camunda.bpm.engine.runtime.ProcessInstance;
import org.camunda.bpm.engine.test.ProcessEngineRule;
import org.camunda.bpm.engine.test.mock.Mocks;
import org.camunda.bpm.extension.process_test_coverage.junit.rules.TestCoverageProcessEngineRuleBuilder;
import org.camunda.bpm.engine.test.Deployment;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import static org.camunda.bpm.engine.test.assertions.ProcessEngineTests.*;
import static org.junit.Assert.*;

public class TestingClass {
	
	@Rule
	public ProcessEngineRule rule = new ProcessEngineRule(new StandaloneInMemProcessEngineConfiguration().buildProcessEngine());
	
	@Test
	@Deployment(resources = "loanApproval.bpmn")
	public void testHappyPath() {

		ProcessEngine processEngine = rule.getProcessEngine();

		ProcessInstance processInstance = processEngine.getRuntimeService().startProcessInstanceByKey("loanApproval");
		
		//assertThat(processInstance).isWaitingAt("Task_0dfv74n").task().hasName("Check the request");
		
		//complete(task(), withVariables("Verification", true));
		
		//complete(task(),withVariables("Verification", true, "CustName", "arnav", "CustAge", 25));
		
		//assertThat(processInstance).isEnded();

	}
	
	@Test
	@Deployment(resources = "loanApproval.bpmn")
	public void testPath() {
		Mocks.register("execute", new JavaDelegate() {
			public void execute(DelegateExecution execution) throws Exception {}
		});
		
		
	}
	
	
	
	
	
	

}
