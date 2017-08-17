package mannafundraising.orderforms;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

@ActiveProfiles(OrderFormsApplicationConfig.PROFILE_LOCAL)
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(loader=AnnotationConfigContextLoader.class, classes={OrderFormsApplicationConfig.class})
public class IntegrationTests {
	
	@Autowired OrderFormsApplication app;

	@Test
	public void testHandleRequest() {
		String result = app.handleRequest("test", null);
		Assert.assertTrue(result != null && result.contains("success"));
	}

}
