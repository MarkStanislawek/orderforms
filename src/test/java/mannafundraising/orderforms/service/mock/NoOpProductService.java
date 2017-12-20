package mannafundraising.orderforms.service.mock;

import java.util.Collections;
import java.util.List;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import mannafundraising.orderforms.OrderFormsApplicationConfig;
import mannafundraising.orderforms.domain.ProductJson;
import mannafundraising.orderforms.service.ProductService;

//@Profile(OrderFormsApplicationConfig.PROFILE_DEV)
//@Component
public class NoOpProductService implements ProductService {

	private static final List<ProductJson> emptyList = Collections.unmodifiableList(Collections.emptyList());
	private static final List<List<ProductJson>> secondEmptyList = Collections.unmodifiableList(Collections.emptyList());

	@Override
	public List<ProductJson> findOnhand() {
		return emptyList;
	}

	@Override
	public List<ProductJson> findBackorder() {
		return emptyList;
	}

	@Override
	public List<List<ProductJson>> findAllSortedByName() {
		return secondEmptyList;
	}

}
