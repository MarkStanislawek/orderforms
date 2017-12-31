package mannafundraising.orderforms.service;

import java.io.IOException;
import java.util.List;

import freemarker.template.TemplateException;
import mannafundraising.common.json.ProductJson;
import mannafundraising.common.json.SaleDateJson;

public interface HtmlFormService {

	List<byte[]> generateOrderForm(List<List<ProductJson>> productJsons, List<SaleDateJson> saleDates)
			throws IOException, TemplateException;

}
