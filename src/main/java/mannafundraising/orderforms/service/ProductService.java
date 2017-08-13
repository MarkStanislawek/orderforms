package mannafundraising.orderforms.service;

import java.util.List;

import mannafundraising.orderforms.entity.Product;

public interface ProductService {
	List<Product> findOnhand();
	
	List<Product> findBackorder();
	
	List<List<Product>> findAllSortByName();
}
