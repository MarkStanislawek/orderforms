package mannafundraising.orderforms.service;

import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import mannafundraising.orderforms.OrderFormsApplicationConfig;

@Component
@Profile(OrderFormsApplicationConfig.PROFILE_DEV)
public class LocalStorageService implements StorageService {

	private Logger logger = Logger.getLogger(LocalStorageService.class.getName());

	@Override
	public boolean store(byte[] file) {
		try (FileOutputStream stream = new FileOutputStream("orderform.html")) {
			stream.write(file);
			return true;
		} catch (IOException ioe) {
			logger.error("exception saving form", ioe);
			return false;
		}
	}

}
