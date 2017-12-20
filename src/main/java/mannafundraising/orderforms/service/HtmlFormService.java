package mannafundraising.orderforms.service;

import java.io.IOException;
import java.util.List;

import freemarker.template.TemplateException;
import mannafundraising.orderforms.domain.ProductJson;
import mannafundraising.orderforms.domain.SaleDateJson;

public interface HtmlFormService {

	List<byte[]> generateOrderForm(List<List<ProductJson>> productJsons, List<SaleDateJson> saleDates)
			throws IOException, TemplateException;

}
