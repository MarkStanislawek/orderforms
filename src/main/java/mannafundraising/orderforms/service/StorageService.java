package mannafundraising.orderforms.service;

import java.util.List;

public interface StorageService {

	void storePdf(byte[] file);

	void storeHtml(List<byte[]> htmlPages);
	
	void storeImages(List<byte[]> images);

}
