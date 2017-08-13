package mannafundraising.orderforms;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import mannafundraising.orderforms.entity.Product;
import mannafundraising.orderforms.service.FormService;
import mannafundraising.orderforms.service.ProductService;

@SpringBootApplication
public class OrderformsApplication {

	private Logger logger = LoggerFactory.getLogger(OrderformsApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(OrderformsApplication.class, args);
	}

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}

	@Bean
	public CommandLineRunner run(ProductService productService, FormService formService) throws Exception {
		return args -> {
			
			List<List<Product>> products = productService.findAllSortByName();
			logger.info(String.format("Received %d products%n",products.stream().mapToInt(List::size).sum()));
			formService.generateOrderForm(products);
		};
	}
}
