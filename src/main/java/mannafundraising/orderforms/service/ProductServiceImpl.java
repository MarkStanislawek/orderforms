package mannafundraising.orderforms.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import mannafundraising.orderforms.entity.Product;

@Service
public class ProductServiceImpl implements ProductService {

	@Value("${products.onhand.url}")
	private String productsOnhandUrl;

	@Value("${products.backorder.url}")
	private String productsBackorderUrl;

	@Value("${products.all.url}")
	private String productsAllUrl;

	private RestTemplate restTemplate;
	
	private Logger logger = LoggerFactory.getLogger(ProductServiceImpl.class);

	@Autowired
	public ProductServiceImpl(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	@Override
	public List<Product> findOnhand() {
		return find(productsOnhandUrl);
	}

	@Override
	public List<Product> findBackorder() {
		return find(productsOnhandUrl);
	}

	@Override
	public List<List<Product>> findAllSortByName() {
		List<Product> products = find(productsAllUrl);
		logger.info(String.format("Received %d products%n",products.size()));
		List<Product> backorderProducts = sortInterleavedByName(
				products.stream().filter(p -> p.isBackorder()).collect(Collectors.toList()));
		List<Product> onhandProducts = sortInterleavedByName(
				products.stream().filter(p -> !p.isBackorder()).collect(Collectors.toList()));
		return new ArrayList<List<Product>>(Arrays.asList(onhandProducts, backorderProducts));

	}

	private List<Product> find(String url) {
		ResponseEntity<List<Product>> productResponse = restTemplate.exchange(url, HttpMethod.GET, null,
				new ParameterizedTypeReference<List<Product>>() {
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
	public static List<Product> sortInterleavedByName(List<Product> products) {
		Collections.sort(products, (p1, p2) -> p1.getName().compareToIgnoreCase(p2.getName()));
		// interleave sorted elements
		List<Product> sorted = new ArrayList<>(products.size());
		int size = products.size();
		int half = size / 2;
		if (size % 2 > 0) {
			half++;
		}
		for (int i = 0; i < half; i++) {
			sorted.add(products.get(i));
			int nextIndex = i + half;
			if (nextIndex < size) {
				sorted.add(products.get(nextIndex));
			}
		}
		return sorted;
	}
}
