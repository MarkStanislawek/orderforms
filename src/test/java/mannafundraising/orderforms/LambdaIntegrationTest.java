package mannafundraising.orderforms;

import org.junit.Test;

import com.amazonaws.services.lambda.runtime.events.KinesisEvent;

public class LambdaIntegrationTest {

	@Test
	public void testHandleRequest() {
		String targetEnv = System.getProperty("target_env");
		System.setProperty("target_env", OrderFormsApplicationConfig.PROFILE_STAGING);
		System.out.printf("LambdaIntegrationTest: changing target_env from %s to %s%n", targetEnv,
				OrderFormsApplicationConfig.PROFILE_STAGING);
		OrderFormsLambdaKinesis lambda = new OrderFormsLambdaKinesis();
		lambda.handleRequest(new KinesisEvent(), null); // TestContext()
		if (targetEnv != null)
			System.setProperty("target_env", targetEnv);
	}

}
