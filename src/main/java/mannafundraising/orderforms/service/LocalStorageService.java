package mannafundraising.orderforms.service;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import mannafundraising.orderforms.OrderFormsApplicationConfig;

@Component
@Profile(OrderFormsApplicationConfig.PROFILE_LOCAL)
public class LocalStorageService implements StorageService {
	
	private Logger logger = Logger.getLogger(LocalStorageService.class.getName());

	@Override
	public boolean store(byte[] file) {
		FileOutputStream stream = null;
		try {
			stream = new FileOutputStream("orderform.html");
			stream.write(file);
			stream.close();
			return true;
		} catch(IOException ioe) {
			logger.log(Level.SEVERE, "exception saving form", ioe);
			return false;
		}
	}

}
