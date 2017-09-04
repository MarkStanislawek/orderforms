package mannafundraising.orderforms;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.SNSEvent;

public class OrderFormsLambdaSNS implements RequestHandler<SNSEvent, Void> {

	private static final ApplicationContext context;
	static {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		ctx.getEnvironment().setActiveProfiles(OrderFormsApplicationConfig.PROFILE_PRODUCTION,
				OrderFormsApplicationConfig.PROFILE_STAGING);
		ctx.register(OrderFormsApplicationConfig.class);
		ctx.refresh();
		context = ctx;
	}

	private static final Logger logger = Logger.getLogger(OrderFormsLambdaSNS.class.getName());

	@Override
	public Void handleRequest(SNSEvent lambdaInput, Context lambdaContext) {
		lambdaInput.getRecords().stream()
				.forEach(r -> logger
						.info(String.format("received SNS with topic %s, message Id %s, and payload %s",
								r.getSNS().getTopicArn(), r.getSNS().getMessageId(), r.getSNS().getMessage())));
		OrderFormsApplication app = context.getBean(OrderFormsApplication.class);
		boolean result = app.processRequest();
		return null;
	}

}
