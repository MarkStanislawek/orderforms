package mannafundraising.orderforms.service.mock;

import java.util.Collections;
import java.util.List;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import mannafundraising.orderforms.OrderFormsApplicationConfig;
import mannafundraising.orderforms.entity.Product;
import mannafundraising.orderforms.service.ProductService;

@Profile(OrderFormsApplicationConfig.PROFILE_DEV)
@Component
public class NoOpProductService implements ProductService {

	private static final List<Product> emptyList = Collections.unmodifiableList(Collections.emptyList());
	private static final List<List<Product>> secondEmptyList = Collections.unmodifiableList(Collections.emptyList());

	@Override
	public List<Product> findOnhand() {
		return emptyList;
	}

	@Override
	public List<Product> findBackorder() {
		return emptyList;
	}

	@Override
	public List<List<Product>> findAllSortedByName() {
		return secondEmptyList;
	}

}
