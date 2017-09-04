package mannafundraising.orderforms;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mannafundraising.orderforms.entity.Product;
import mannafundraising.orderforms.service.HtmlFormService;
import mannafundraising.orderforms.service.ImageService;
import mannafundraising.orderforms.service.PdfService;
import mannafundraising.orderforms.service.ProductService;
import mannafundraising.orderforms.service.StorageService;

@Component
public class OrderFormsApplication {
	private Logger logger = Logger.getLogger(OrderFormsApplication.class.getName());
	
	@Autowired private ProductService productService;
	@Autowired private HtmlFormService htmlFormService;
	@Autowired private ImageService imageService;
	@Autowired private PdfService pdfService;
	@Autowired private StorageService storeService;

	public boolean processRequest() {
		try {
			List<List<Product>> products = productService.findAllSortByName();
			List<byte[]> htmlPages = htmlFormService.generateOrderForm(products);
			List<byte[]> images = imageService.createImageFromHtml(htmlPages);
			storeService.storeImages(images);
			byte[] pdf = pdfService.createPdfFromImage(images);
			storeService.storePdf(pdf);
			return true;
		} catch (Exception e) {
			logger.error("failed to generate order form", e);
			return false;
		}
	}
}
