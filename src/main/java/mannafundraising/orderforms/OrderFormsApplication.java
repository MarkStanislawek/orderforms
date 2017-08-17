package mannafundraising.orderforms;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mannafundraising.orderforms.entity.Product;
import mannafundraising.orderforms.service.FormService;
import mannafundraising.orderforms.service.ProductService;
import mannafundraising.orderforms.service.StorageService;

@Component
public class OrderFormsApplication {
	private Logger logger = Logger.getLogger(OrderFormsApplication.class.getName());
	
	@Autowired private ProductService productService;
	@Autowired private FormService formService;
	@Autowired private StorageService storeService;

	public boolean processRequest() {
		try {
			List<List<Product>> products = productService.findAllSortByName();
			byte[] form = formService.generateOrderForm(products);
			storeService.store(form);
			return true;
		} catch (Exception e) {
			logger.error("failed to generate order form", e);
			return false;
		}
	}
}
