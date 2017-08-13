package mannafundraising.orderforms.service;

import java.util.List;

import mannafundraising.orderforms.entity.Product;

public interface FormService {
	void generateOrderForm(List<List<Product>> products) throws Exception;
}
