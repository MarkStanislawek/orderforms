package mannafundraising.orderforms.service;

import java.util.List;

import mannafundraising.orderforms.domain.ProductJson;

public interface ProductService {
	List<ProductJson> findOnhand();
	
	List<ProductJson> findBackorder();
	
	List<List<ProductJson>> findAllSortedByName();
}
