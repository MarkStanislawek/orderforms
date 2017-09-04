package mannafundraising.orderforms.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import mannafundraising.orderforms.OrderFormsApplicationConfig;

@Component
@Profile(OrderFormsApplicationConfig.PROFILE_DEV)
public class LocalStorageService implements StorageService {

	private Logger logger = Logger.getLogger(LocalStorageService.class.getName());

	@Override
	public void storePdf(byte[] file) {
		store(new File("orderform." + file.hashCode() + ".pdf"), file);
	}

	private void store(File f, byte[] bytes) {
		try (FileOutputStream stream = new FileOutputStream(f)) {
			stream.write(bytes);
			logger.info(String.format("Wrote %d bytes to %s", bytes.length, f.getAbsolutePath()));
		} catch (IOException ioe) {
			logger.error("exception saving form", ioe);
		}
	}

	@Override
	public void storeHtml(List<byte[]> files) {
		int pageNbr = 1;
		for (byte[] file : files) {
			store(new File(String.format("orderform-p%d.html", pageNbr++)), file);
		}
	}

	@Override
	public void storeImages(List<byte[]> images) {
		int imageNbr = 1;
		for (byte[] image : images) {
			store(new File(String.format("orderform-p%d.png", imageNbr++)), image);
		}
		
	}

}
