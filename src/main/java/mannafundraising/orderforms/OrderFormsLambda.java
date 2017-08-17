package mannafundraising.orderforms;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.KinesisEvent;

public class OrderFormsLambda implements RequestHandler<KinesisEvent, Void> {

	private static final ApplicationContext context;
	static {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		ctx.getEnvironment().setActiveProfiles(OrderFormsApplicationConfig.PROFILE_PRODUCTION,
				OrderFormsApplicationConfig.PROFILE_STAGING);
		ctx.register(OrderFormsApplicationConfig.class);
		ctx.refresh();
		context = ctx;
	}

	@Override
	public Void handleRequest(KinesisEvent lambdaInput, Context lambdaContext) {
		OrderFormsApplication app = context.getBean(OrderFormsApplication.class);
		boolean result = app.processRequest();
		return null;
	}

}
