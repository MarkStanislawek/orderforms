package mannafundraising.orderforms.service;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfig;

import freemarker.core.ParseException;
import freemarker.template.MalformedTemplateNameException;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateNotFoundException;
import mannafundraising.orderforms.entity.Product;

@Service
public class FormServiceImpl implements FormService {
	
	private FreeMarkerConfig cfg;
	
	@Autowired
	public FormServiceImpl(FreeMarkerConfig cfg) {
		this.cfg = cfg;
	}
	
	
	
	@Override
	public void generateOrderForm(List<List<Product>> products) throws TemplateNotFoundException, MalformedTemplateNameException, ParseException, IOException, TemplateException {
		Map<String,Object> root = new HashMap<>();
		root.put("onhandProducts", products.get(0));
		root.put("backorderProducts", products.get(1));
		Template temp = cfg.getConfiguration().getTemplate("MannaOrderForm.ftl");
		Writer out = new OutputStreamWriter(new FileOutputStream("orderform.html"));
		temp.process(root, out);
		out.close();
	}

}
