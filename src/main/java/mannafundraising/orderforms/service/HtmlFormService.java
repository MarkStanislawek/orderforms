package mannafundraising.orderforms.service;

import java.util.List;

import mannafundraising.orderforms.entity.Product;

public interface HtmlFormService {
	List<byte[]> generateOrderForm(List<List<Product>> products) throws Exception;
}
