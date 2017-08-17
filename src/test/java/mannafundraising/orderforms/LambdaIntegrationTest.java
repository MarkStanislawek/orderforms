package mannafundraising.orderforms;

import org.junit.Test;

import com.amazonaws.services.lambda.runtime.events.KinesisEvent;

public class LambdaIntegrationTest {

	@Test
	public void testHandleRequest() {
		OrderFormsLambda lambda = new OrderFormsLambda();
		lambda.handleRequest(new KinesisEvent(), null);  // TestContext()
	}

}
