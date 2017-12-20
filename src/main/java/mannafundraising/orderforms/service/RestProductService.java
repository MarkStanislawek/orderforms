package mannafundraising.orderforms.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import mannafundraising.orderforms.OrderFormsApplicationConfig;
import mannafundraising.orderforms.domain.ProductJson;

@Component
@Profile({ OrderFormsApplicationConfig.PROFILE_DEV, OrderFormsApplicationConfig.PROFILE_STAGING, OrderFormsApplicationConfig.PROFILE_PRODUCTION })
public class RestProductService implements ProductService {

	@Value("${products.onhand.url}")
	private String productsOnhandUrl;

	@Value("${products.backorder.url}")
	private String productsBackorderUrl;

	@Value("${products.all.url}")
	private String productsAllUrl;

	private Logger logger = Logger.getLogger(RestProductService.class.getName());

	@Override
	public List<ProductJson> findOnhand() {
		return find(productsOnhandUrl);
	}

	@Override
	public List<ProductJson> findBackorder() {
		return find(productsOnhandUrl);
	}

	@Override
	public List<List<ProductJson>> findAllSortedByName() {
		List<ProductJson> productJsons = find(productsAllUrl);
		logger.info(String.format("Received %d products", productJsons.size()));
		List<ProductJson> backorderProducts = sortInterleavedByName(
				productJsons.stream().filter(p -> p.isBackorder()).collect(Collectors.toList()));
		List<ProductJson> onhandProducts = sortInterleavedByName(
				productJsons.stream().filter(p -> !p.isBackorder()).collect(Collectors.toList()));
		return new ArrayList<List<ProductJson>>(Arrays.asList(onhandProducts, backorderProducts));

	}

	private List<ProductJson> find(String url) {
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<List<ProductJson>> productResponse = restTemplate.exchange(url, HttpMethod.GET, null,
				new ParameterizedTypeReference<List<ProductJson>>() {
				});
		return productResponse.getBody();
	}

	/**
	 * interleaving sort by name. The list is sorted alphabetically, split in
	 * two and then interleaved into the result. Elements alternate in the
	 * result from the first and second set.
	 * 
	 * @return
	 */
	public static List<ProductJson> sortInterleavedByName(List<ProductJson> productJsons) {
		Collections.sort(productJsons, (p1, p2) -> p1.getName().compareToIgnoreCase(p2.getName()));
		// interleave sorted elements
		List<ProductJson> sorted = new ArrayList<>(productJsons.size());
		int size = productJsons.size();
		int half = size / 2;
		if (size % 2 > 0) {
			half++;
		}
		for (int i = 0; i < half; i++) {
			sorted.add(productJsons.get(i));
			int nextIndex = i + half;
			if (nextIndex < size) {
				sorted.add(productJsons.get(nextIndex));
			}
		}
		return sorted;
	}
}
