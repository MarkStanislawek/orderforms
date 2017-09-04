package mannafundraising.orderforms.service;

import java.util.List;

public interface PdfService {

	byte[] createPdfFromHtml(List<byte[]> pages) throws Exception;
	
	byte[] createPdfFromImage(List<byte[]> images) throws Exception;

}
