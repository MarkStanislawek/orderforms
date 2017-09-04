package mannafundraising.orderforms.service;

import java.util.List;

public interface ImageService {
	
	List<byte[]> createImageFromHtml(List<byte[]> htmlPages) throws Exception;

}
