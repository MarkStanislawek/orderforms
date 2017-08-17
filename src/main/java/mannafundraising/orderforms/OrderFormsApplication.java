package mannafundraising.orderforms;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

import mannafundraising.orderforms.entity.Product;
import mannafundraising.orderforms.service.FormService;
import mannafundraising.orderforms.service.ProductService;
import mannafundraising.orderforms.service.StorageService;

@Component
public class OrderFormsApplication implements RequestHandler<String, String> {
	private Logger logger = Logger.getLogger(OrderFormsApplication.class.getName());
	
	@Autowired private ProductService productService;
	@Autowired private FormService formService;
	@Autowired private StorageService storeService;

	@Override
	public String handleRequest(String input, Context ctx) {
		try {
			List<List<Product>> products = productService.findAllSortByName();
			byte[] form = formService.generateOrderForm(products);
			storeService.store(form);
			return "{ \"status\": \"success\" }";
		} catch (Exception e) {
			logger.log(Level.SEVERE, "failed to generate order form", e);
			return "{ \"status\": \"failure\" }";
		}
	}
}
