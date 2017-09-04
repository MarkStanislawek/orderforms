package mannafundraising.orderforms;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

@ActiveProfiles(OrderFormsApplicationConfig.PROFILE_DEV)
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(loader=AnnotationConfigContextLoader.class, classes={OrderFormsApplicationConfig.class})
public class IntegrationTests {
	
	@Autowired OrderFormsApplication app;
	
	public static String targetEnv = null;
	
	@BeforeClass
	public static void setup() {
		targetEnv = System.getProperty("target_env");
		System.setProperty("target_env", OrderFormsApplicationConfig.PROFILE_DEV);
	}
	
	@AfterClass
	public static void tearDown() {
		if (targetEnv != null)
			System.setProperty("target_env", targetEnv);
	}

	@Test
	public void testHandleRequest() {
		boolean success = app.processRequest();
		Assert.assertTrue(success);
	}

}
