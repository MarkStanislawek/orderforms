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
import mannafundraising.orderforms.entity.Product;

@Component
public class FreemarkerFormService implements HtmlFormService {

	@Autowired
	private Configuration cfg;

	@Override
	public List<byte[]> generateOrderForm(List<List<Product>> products) throws TemplateNotFoundException,
			MalformedTemplateNameException, ParseException, IOException, TemplateException {
		List<byte[]> pages = new ArrayList<>();
		ByteArrayOutputStream stream = new ByteArrayOutputStream();
		Map<String, Object> root = new HashMap<>();
		
		if (products != null && products.size() >= 2) {
			Iterator<List<Product>> iter = products.iterator();
			root.put("onhandProducts", iter.next());
			root.put("backorderProducts", iter.next());
		}
		Template temp = cfg.getTemplate("MannaOrderForm-p1.ftl");
		Writer writer = new OutputStreamWriter(stream);
		temp.process(root, writer);
		pages.add(stream.toByteArray());
		stream.reset();
		temp = cfg.getTemplate("MannaOrderForm-p2.ftl");
		writer = new OutputStreamWriter(stream);
		temp.process(root, writer);
		pages.add(stream.toByteArray());
		return pages;
	}

}
