package mannafundraising.orderforms.service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import freemarker.core.ParseException;
import freemarker.template.Configuration;
import freemarker.template.MalformedTemplateNameException;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateNotFoundException;
import mannafundraising.common.json.ProductJson;
import mannafundraising.common.json.SaleDateJson;

@Component
public class FreemarkerFormService implements HtmlFormService {

	@Autowired
	private Configuration cfg;

	@Override
	public List<byte[]> generateOrderForm(List<List<ProductJson>> productJsons, List<SaleDateJson> saleDates)
			throws IOException, TemplateException {
		Map<String, Object> dataModel = createProductDataModel(productJsons);
		dataModel.putAll(createSaleDateDataModel(saleDates));
		return createPages(dataModel);
	}

	private List<byte[]> createPages(Map<String, Object> dataModel) throws TemplateNotFoundException,
			MalformedTemplateNameException, ParseException, IOException, TemplateException {
		List<byte[]> pages = new ArrayList<>();
		pages.add(createPage("MannaOrderForm-p1.ftl", dataModel));
		pages.add(createPage("MannaOrderForm-p2.ftl", dataModel));
		return pages;
	}

	private byte[] createPage(String templateName, Map<String, Object> dataModel) throws TemplateNotFoundException,
			MalformedTemplateNameException, ParseException, IOException, TemplateException {
		ByteArrayOutputStream stream = new ByteArrayOutputStream();
		Template temp = cfg.getTemplate(templateName);
		Writer writer = new OutputStreamWriter(stream);
		temp.process(dataModel, writer);
		return stream.toByteArray();
	}

	private Map<String, Object> createProductDataModel(List<List<ProductJson>> productJsons) {
		Map<String, Object> model = new HashMap<>();
		if (productJsons != null && productJsons.size() >= 2) {
			Iterator<List<ProductJson>> iter = productJsons.iterator();
			model.put("onhandProducts", iter.next());
			model.put("backorderProducts", iter.next());
		}
		return model;
	}

	private Map<String, Object> createSaleDateDataModel(List<SaleDateJson> saleDates) {
		Map<String, Object> model = new HashMap<>();
		if (saleDates != null)
			model.put("saleDates", saleDates);
		return model;
	}

}
