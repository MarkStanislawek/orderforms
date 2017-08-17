package mannafundraising.orderforms.service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.HashMap;
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
public class FreemarkerFormService implements FormService {
	
	@Autowired
	private Configuration cfg;
		
	@Override
	public byte[] generateOrderForm(List<List<Product>> products) throws TemplateNotFoundException, MalformedTemplateNameException, ParseException, IOException, TemplateException {
		Map<String,Object> root = new HashMap<>();
		root.put("onhandProducts", products.get(0));
		root.put("backorderProducts", products.get(1));
		Template temp = cfg.getTemplate("MannaOrderForm.ftl");
		ByteArrayOutputStream stream = new ByteArrayOutputStream();
		Writer writer = new OutputStreamWriter(stream);
		temp.process(root, writer);
		writer.close();
		return stream.toByteArray();
	}

}
